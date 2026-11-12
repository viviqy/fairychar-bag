import argparse
from collections import Counter
from pathlib import Path
import re
from urllib.parse import unquote, urlsplit


INTERNAL_TYPES = {
    "com.fairychar.bag.domain.spring.BeanAwareMarker",
    "com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice",
    "com.fairychar.bag.beans.spring.advice.InvalidateLog",
    "com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice",
    "com.fairychar.bag.domain.netty.advice.GlobalInboundEventAdvice",
    "com.fairychar.bag.pojo.vo.InvalidateFieldVO",
    "com.fairychar.bag.beans.spring.mvc.EraseValueAdvice",
    "com.fairychar.bag.beans.spring.mvc.FuzzyMiddleTextProcessor",
    "com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice",
    "com.fairychar.bag.beans.spring.mvc.FuzzyValueProcessor",
    "com.fairychar.bag.beans.spring.mvc.KeepValueAdvice",
    "com.fairychar.bag.beans.swagger.RequestIgnoreParameterPlugin",
    "com.fairychar.bag.beans.swagger.ShowParam",
    "com.fairychar.bag.configurer.BagBeansAutoConfigurer",
}


def anchors(text):
    result = set(re.findall(r'<a\s+id="([^"]+)"', text))
    repeated = Counter()
    for heading in re.findall(r"^#{1,6}\s+(.+)$", text, re.MULTILINE):
        heading = re.sub(r"\[([^\]]+)\]\([^)]+\)", r"\1", heading)
        heading = re.sub(r"[^\w\s-]", "", heading.lower()).replace(" ", "-")
        suffix = f"-{repeated[heading]}" if repeated[heading] else ""
        result.add(heading + suffix)
        repeated[heading] += 1
    return result


def verify(root):
    errors = []
    files = sorted(root.rglob("*.md"))
    for file in files:
        text = file.read_text(encoding="utf-8-sig")
        consumer_document = "maintenance" not in file.relative_to(root).parts
        if re.search(r"DefaultExceptionAdvice|InvalidateLog|GlobalInboundCauseAdvice|GlobalInboundEventAdvice|InvalidateFieldVO", text):
            errors.append(f"{file.relative_to(root)}: removed internal-type documentation must not return")
        if re.search(r"老 Swagger 参数展示|旧 Swagger|RequestIgnoreParameterPlugin|ShowParam", text):
            errors.append(f"{file.relative_to(root)}: removed parameter-display documentation must not return")
        if consumer_document and re.search(r"先看源码|先修(?:复|正)?源码|源码修复|修复源码|修正源码", text):
            errors.append(f"{file.relative_to(root)}: SDK repair guidance is not a consumer task")
        for target in re.findall(r"\[[^\]\n]+\]\(([^)\n]+)\)", text):
            parsed = urlsplit(target)
            if parsed.scheme or parsed.netloc:
                continue
            destination = (file.parent / unquote(parsed.path)).resolve() if parsed.path else file
            if consumer_document:
                if not destination.is_relative_to(root):
                    errors.append(f"{file.relative_to(root)}: consumer link must not require SDK sources: {target}")
                elif "maintenance" in destination.relative_to(root).parts or destination.name in {
                    "GenerateSdkApiIndex.java", "verify-sdk-guide.py", "verify-fairychar-bag-compile.ps1",
                    "SdkUsageExamples.java", "SdkContractExamples.java"
                }:
                    errors.append(f"{file.relative_to(root)}: consumer route must not load maintenance artifacts: {target}")
            if not destination.exists():
                errors.append(f"{file.relative_to(root)}: missing target {target}")
            elif parsed.fragment and destination.is_file() and destination.suffix == ".md":
                if unquote(parsed.fragment) not in anchors(destination.read_text(encoding="utf-8-sig")):
                    errors.append(f"{file.relative_to(root)}: missing anchor {target}")

    entry = root / "fairychar-bag-usage-guide.md"
    feature_files = set((root / "features").rglob("*.md"))
    if not feature_files:
        errors.append("Missing feature documents")
    entry_text = entry.read_text(encoding="utf-8-sig")
    entry_targets = {
        (entry.parent / unquote(urlsplit(target).path)).resolve()
        for target in re.findall(r"\[[^\]\n]+\]\(([^)\n]+)\)", entry_text)
        if not urlsplit(target).scheme
    }
    for file in sorted(feature_files):
        text = file.read_text(encoding="utf-8-sig")
        if file.resolve() not in entry_targets:
            errors.append(f"{file.relative_to(root)}: feature must be directly reachable from entry")
        if "## 用途与采用边界" not in text or "**采用状态：" not in text:
            errors.append(f"{file.relative_to(root)}: missing adoption boundary")
        if "## 类型与完整签名" not in text:
            errors.append(f"{file.relative_to(root)}: missing signature route")
    for legacy in ["references", "scripts"]:
        if any(path.is_file() for path in (root / legacy).rglob("*")):
            errors.append(f"Legacy parallel documentation directory: {legacy}")

    api = root / "api"
    declaration_names = []
    feature_owners = {}
    totals = Counter()
    titles = {
        "public 构造器": "constructors",
        "当前类型声明的 public 方法": "methods",
        "public 字段 / 枚举常量": "fields",
    }
    for file in sorted(api.glob("*.md")):
        if file.name == "README.md":
            continue
        text = file.read_text(encoding="utf-8-sig")
        declaration_names.extend(re.findall(r"^## `(com\.fairychar\.bag\.[^`]+)`$", text, re.MULTILINE))
        for declaration in re.finditer(
            r"^## `(com\.fairychar\.bag\.[^`]+)`$\n(.*?)(?=^## `com\.fairychar\.bag\.|\Z)",
            text, re.MULTILINE | re.DOTALL
        ):
            targets = re.findall(r"^使用说明：\[[^\]]+\]\(([^)]+)\)。$", declaration.group(2), re.MULTILINE)
            if len(targets) != 1:
                errors.append(f"{file.relative_to(root)}: type must have one behavior owner: {declaration.group(1)}")
                continue
            owner = (file.parent / unquote(urlsplit(targets[0]).path)).resolve()
            if owner not in feature_files:
                errors.append(f"{file.relative_to(root)}: type must route directly to a feature: {declaration.group(1)}")
            feature_owners[declaration.group(1)] = owner
        for title, category in titles.items():
            for block in re.findall(r"^### " + re.escape(title) + r"\n\n```java\n(.*?)\n```", text, re.MULTILINE | re.DOTALL):
                totals[category] += len(block.splitlines())
    duplicates = [name for name, count in Counter(declaration_names).items() if count > 1]
    if duplicates:
        errors.append("Duplicate public type entries: " + ", ".join(duplicates))
    internal_types = [name for name in declaration_names if name.startswith("com.fairychar.bag.aop.")
                      or any(name == excluded or name.startswith(excluded + ".") or name.startswith(excluded + "$")
                             for excluded in INTERNAL_TYPES)]
    if internal_types:
        errors.append("Internal types must not appear in the consumer API index: " + ", ".join(internal_types))
    for file in sorted(feature_files):
        for name in re.findall(r"\[`(com\.fairychar\.bag\.[^`]+)`\]", file.read_text(encoding="utf-8-sig")):
            if feature_owners.get(name) != file.resolve():
                errors.append(f"{file.relative_to(root)}: type claimed by a different feature: {name}")
    totals["types"] = len(declaration_names)
    catalog = api / "README.md"
    if catalog.is_file():
        match = re.search(r"^\| (\d+) \| (\d+) \| (\d+) \| (\d+) \|$", catalog.read_text(encoding="utf-8-sig"), re.MULTILINE)
        actual = tuple(totals[name] for name in ["types", "constructors", "methods", "fields"])
        if not match or tuple(map(int, match.groups())) != actual:
            errors.append(f"API catalog totals differ from declaration pages: {actual}")
    else:
        errors.append("Missing API catalog")
    if errors:
        raise SystemExit("\n".join(errors))
    print(f"Verified {len(files)} Markdown files, local links/anchors, unique API entries and totals: {dict(totals)}")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Verify SDK guide links and generated index structure without modifying files.")
    parser.add_argument("--guide-root", type=Path, default=Path(__file__).resolve().parents[1])
    arguments = parser.parse_args()
    verify(arguments.guide_root.resolve())
