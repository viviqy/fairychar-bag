# Code navigation maintenance

The formal entry point is [code-guide/README.md](code-guide/README.md). Configuration and acceptance cases live beside it, outside the replaceable snapshot. Paths are relative to the Git repository root, one directory above the `fairychar-bag` module.

## Scope and limitations

- Index the core library, security core, security starter and the two micro-service Java source templates. Template declarations do not establish a deployed application.
- Keep the default production-only policy: tests, test-like directories (including `utils/test`), build/configuration inputs, resources, documentation, generated output and caches are not navigation inputs. `upgrade-dependencies-test` is not a production root.
- Module manifests were inspected to establish scope, not included in the snapshot. Resource-based registration, mapper XML, generated Lombok/MapStruct declarations, dependency injection and runtime dispatch remain unknown.
- A missing test link is not evidence of missing tests. The Maven command in the snapshot is an unexecuted compilation candidate, not a passing build or a test recommendation inferred from test discovery.
- Four reviewed explanations cover selected exception, scheduling, authentication and bean-configuration boundaries only. All other behavior requires source review. Source hashes bind reviewed claims; review and refresh those claims after relevant source changes.
- Leave previous guides elsewhere and existing staged changes untouched. Only `code-guide/` is the published navigation entry point; `code-guide-work/` contains run-specific staging/results and retained previous snapshots.

## Task routes

1. Exception payload or error-code contract: query `com.fairychar.bag.domain.exceptions.RestException`, inspect its four constructors and fields, then inspect current consumers in source.
2. Scheduling or executor lifecycle: query `com.fairychar.bag.template.ActionSelectorTemplate`, inspect `put`, `remove`, `start` and shutdown methods. Lambda and executor behavior need direct source review.
3. JSON login: query `com.fairychar.security.core.auth.filter.JsonAuthenticationFilter`, then inspect its request interface, decryptors and effective filter registration in current source.
4. Default security beans: query `com.fairychar.security.boot.configurer.CommonBeansConfiguration`; resource registration and runtime bean conditions are outside this snapshot.
5. For every change, retrieve incoming impact candidates and outgoing dependencies separately, run `verify`, and read bounded unknowns before selecting real verification.

## Reproduce and query

Run in PowerShell from the Git repository root. Requires Python, a same-home JDK 21+ with `java`/`javac`, and the installed `generating-code-navigation` skill. Generation parses syntax without annotation processors, application execution or dependency downloads.

```powershell
$scripts = Join-Path $env:USERPROFILE '.codex/skills/generating-code-navigation/scripts'
python "$scripts/generate_navigation.py" --root . --config codingRuntime/code-guide.config.json
python "$scripts/validate_navigation.py" codingRuntime/code-guide
python "$scripts/tests/java_inventory.py" --root . --guide codingRuntime/code-guide
python "$scripts/benchmark_navigation.py" --cases codingRuntime/code-guide.acceptance.json --guide codingRuntime/code-guide
python "$scripts/query_navigation.py" --root . --guide codingRuntime/code-guide freshness
python "$scripts/query_navigation.py" --root . --guide codingRuntime/code-guide symbol --target com.fairychar.bag.domain.exceptions.RestException --limit 5
```

Use the exact `symbolId` returned by a symbol query to avoid overload ambiguity:

```powershell
python "$scripts/query_navigation.py" --root . --guide codingRuntime/code-guide impact --target <symbolId> --direction incoming --relation-kind calls --depth 2 --limit 20
python "$scripts/query_navigation.py" --root . --guide codingRuntime/code-guide impact --target <symbolId> --direction outgoing --depth 2 --limit 20
python "$scripts/query_navigation.py" --root . --guide codingRuntime/code-guide verify --target <symbolId>
python "$scripts/query_navigation.py" --root . --guide codingRuntime/code-guide explain --target <symbolId>
```

Generation validates a run-specific candidate, including the acceptance cases, before publication with a lock, directory rename and rollback backup. A full rebuild is used; incremental record reuse is not implemented. Do not edit generated projections directly.
