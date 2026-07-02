---
name: fairychar-coding-java
description: Use when writing, reviewing, or refactoring Java code in Fairychar Bag style or under fairychar-bag/src
---

# Fairychar Coding Java

## Overview

Fairychar Bag Java favors reusable starter utilities: opt-in auto-configuration, annotation extension points, AOP helpers, validators, servlet/request utilities, Netty wrappers, Redis serializers, Lombok POJOs, and unified REST exceptions. Follow `fairychar-bag/src` style before generic Java preferences.

## Progressive Loading

Load only what the task needs:

| Task | Load |
| --- | --- |
| Any `fairychar-bag/src` Java edit or review | `reference/project-style.md` |
| Need original style examples without the project checkout | Read `code/src/main/java/com/fairychar/bag/...` |
| Quick style audit | Run `script/check-fairychar-style.ps1`; pass `-Root` only when checking a target source tree |

## Standalone Use

Keep `SKILL.md`, `reference/`, `script/`, and `code/` together when installing this skill outside the project. `code/` contains copied source snapshots used as style evidence; it is not a complete buildable project. When no target source tree is available, use those files as the canonical examples.

## Quick Rules

- Scope: only infer from `fairychar-bag/src`; ignore sibling modules, root docs, and generated archetype code.
- When the original project is unavailable, infer from this skill's copied examples under `code/src/main/java`.
- Baseline: Java 17, UTF-8, Spring Boot 3 style.
- Formatting: no tabs, target 140 columns, required braces, Checkstyle names; allowed abbreviations include `ID`, `URL`, `XML`.
- Keep local naming: `I*` interfaces, `*Query`, `*VO`, `*Properties`, `*Util`, `*Template`, `*Configurer`, `*AspectJ`, `*Handler`.
- Shared constants and common singleton holders live in domain containers such as `Consts` and `Singletons`; keep constants uppercase and singleton access through `getInstance()`.
- POJOs commonly use Lombok `@Data`, all/no-args constructors, `@Accessors(chain = true)`, field comments, and `@Schema`.
- Utility classes are usually `final` with `@NoArgsConstructor(access = AccessLevel.PRIVATE)`.
- REST failures use `RestException` + `RestErrorCode`; responses use `HttpResult`.
- Error code definitions implement `IRestErrorCode` and expose stable `int getCode()` + `String getMessage()` values.
- Define REST error codes as enums, grouped by numeric ranges with concise Chinese messages; do not scatter raw code/message literals in services.
- When adding domain-specific error-code sets, keep the `IRestErrorCode` contract and update exception/response APIs to consume the interface consistently before using them.
- Optional starter beans need `@ConditionalOnProperty`; defaults should allow `@ConditionalOnMissingBean`.

## Common Mistakes

| Mistake | Fix |
| --- | --- |
| Inferring rules from sibling modules or archetype modules. | Use only `fairychar-bag/src` as evidence. |
| Replacing `I*` interfaces or field `@Autowired` because generic Java style says so. | Match the touched class unless doing a deliberate migration. |
| Returning raw maps or ad hoc response classes. | Use `HttpResult`, `RestException`, and `RestErrorCode`. |
| Defining exceptions with magic numbers, duplicated messages, or plain strings. | Put codes/messages in an `IRestErrorCode` enum and throw/return through the project REST exception path. |
| Creating unconditional auto-config beans. | Add property gates and missing-bean overrides. |
| Treating tests as unnecessary because Maven skips them. | Add focused tests for new behavior; note existing coverage is light and `skipTests=true`. |

## Verification

- For style drift, run `powershell -ExecutionPolicy Bypass -File <skill-dir>/script/check-fairychar-style.ps1`; pass `-Root <source-root>` only when checking a target tree.
- For auto-config changes, confirm `fairychar-bag/src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`.
