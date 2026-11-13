# Code Navigation

Snapshot: `snapshot-20261113T014229Z-bb422342`

## Progressive loading
1. Choose a module below, then a package and symbol document.
2. For a known name, search catalog.jsonl with rg; disambiguate by owner, path and signature.
3. For impact/tests, use query_navigation.py; candidate edges do not establish actual runtime dispatch.
4. Read current source and relevant tests before behavior changes; all semantic coverage remains incomplete unless specifically reviewed.

## Modules
- [fairychar-bag](modules/fairychar-bag/README.md)
- [fairychar-security-boot-starter](modules/fairychar-security-boot-starter/README.md)
- [fairychar-security-core](modules/fairychar-security-core/README.md)
- [micro-service-api-template](modules/micro-service-api-template/README.md)
- [micro-service-app-template](modules/micro-service-app-template/README.md)

## Scan scope

Default corpus: production source code. Effective policy: `{"includeBuild": false, "includeNonCode": false, "includeTests": false, "productionFiles": [], "sourceExtensions": []}`.

Outside this snapshot: tests; build/configuration inputs; non-code metadata/resources/docs; dependency/vendor/cache/generated/output directories.
Skipped inputs are not read, hashed or projected. Missing tests/build edges do not establish absence of tests or build dependencies.

## Repository map

Inventory-backed structure, not an inferred runtime architecture. Category labels come from project configuration.

| Module | Files | Languages / inputs | Categories |
| --- | ---: | --- | --- |
| [fairychar-bag](modules/fairychar-bag/README.md) | 169 | java: 169 | source: 169 |
| [fairychar-security-boot-starter](modules/fairychar-security-boot-starter/README.md) | 2 | java: 2 | source: 2 |
| [fairychar-security-core](modules/fairychar-security-core/README.md) | 113 | java: 113 | source: 113 |
| [micro-service-api-template](modules/micro-service-api-template/README.md) | 1 | java: 1 | archetype-source: 1 |
| [micro-service-app-template](modules/micro-service-app-template/README.md) | 1 | java: 1 | archetype-source: 1 |

## Task routes

- Locate an unfamiliar feature: module → package/file index → independent declaration; search catalog by name/path if known.
- Inspect a contract or data type: declaration signature → owner/fields → live source for behavior and lifecycle.
- Assess a change: impact --direction incoming (candidate dependants); separately use --direction outgoing for dependencies.
- Choose verification: verify → test evidence and command candidates; a suggested command is not a passing test.
- Investigate behavior: start with reviewed responsibilities below, then source; missing explanations are unknowns, not inferred facts.

## Reviewed responsibilities

- [com.fairychar.bag.domain.exceptions.RestException](modules/fairychar-bag/files/fairychar-bag/src/main/java/com/fairychar/bag/domain/exceptions/RestException.java/RestException.md#symbol-5bcbf9a46b12c556) — Exception carrier: four explicit constructors retain an IRestErrorCode and optionally an Object payload. Constructors without an explicit message pass errorCode.getMessage() to RuntimeException; message-taking overloads pass msg. The payload is assigned only by overloads accepting data. (evidence: `f5dd16fe7c18ca5bd80def936ae67e096cdb77119a76bd02ed1590f577db14b9`)
- [com.fairychar.bag.template.ActionSelectorTemplate](modules/fairychar-bag/files/fairychar-bag/src/main/java/com/fairychar/bag/template/ActionSelectorTemplate.java/ActionSelectorTemplate.md#symbol-64b3f560953c4115) — Scheduling hub: start submits a polling loop to boss; due entries acquire their working flag with compareAndSet before worker submission, update last-execution time, and clear the working flag in the worker finally block. put overloads validate positive periods, non-null actions and duplicate task names; remove can interrupt actions. Shutdown methods request executor shutdown and change runState, without awaiting termination. (evidence: `d0867fa3b6df20e56083c6bbb7a06ebcd16104716772f2bbc14a7b6585798c1f`)
- [com.fairychar.security.core.auth.filter.JsonAuthenticationFilter](modules/fairychar-security-core/files/fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/JsonAuthenticationFilter.java/JsonAuthenticationFilter.md#symbol-80b00d0f9c89cf16) — JSON authentication boundary: attemptAuthentication rejects non-POST requests, compares the content type against two JSON constants, deserializes the request stream into requestClazz, optionally decrypts username and password, sets authentication details and delegates to the configured authentication manager. AuthenticationException is rethrown; other exceptions inside the deserialization/authentication try block become BadCredentialsException. Content-type access occurs before that try block. (evidence: `d87cb32ff4350cf6884be700980afa753aa0dea8bd6108d77f8f78ff4d4291fd`)
- [com.fairychar.security.boot.configurer.CommonBeansConfiguration](modules/fairychar-security-boot-starter/files/fairychar-security/fairychar-security-boot-starter/src/main/java/com/fairychar/security/boot/configurer/CommonBeansConfiguration.java/CommonBeansConfiguration.md#symbol-5624342e4deb0c82) — Security bean configuration declares conditional bean methods for authentication success/failure, access denial, authentication entry point and logout success. Success/failure/logout factories pass optional post-handler lists when present; the entry-point factory supplies an empty mapping. Source annotations enable FairycharSecurityProperties and request ordering after RedisAutoConfiguration; effective runtime activation is not established. (evidence: `936115b79404d231064734b2d3848d0aa6f75730109bf9071172d4c96b8eb25c`)


## Evidence and limitations
- inventory.jsonl: scope, excluded binaries and input hashes.
- facts/: authoritative adapter output, declarations, exact ranges, signatures and fields.
- relations.jsonl: verified lexical ownership; candidate references/calls/test links; unresolved imports.
- claims.jsonl: hash-bound reviewed claims only; not mechanically guessed business semantics.
- gaps.jsonl: per-file diagnostics and unverified analysis scope.
- generation-state.json: config/tool/input digests and verification command candidates, not execution results.

## Queries
Run the skill's scripts/query_navigation.py with --root <repository> --guide <outputRoot>, then symbol, task, impact, verify, explain or freshness. Use --limit and --offset to bound context. Freshness scans configured paths, including added/deleted files, config and analyzer changes.

## Metrics
{"fileCount": 286, "includedFiles": 286, "symbolCount": 2255, "factCount": 2541, "relationCounts": {"references:candidate": 644, "calls:unresolved": 2478, "owns:verified": 1969, "inherits-or-implements:candidate": 37, "calls:candidate": 120, "imports:candidate": 307, "imports:unresolved": 1628}, "claimCount": 4, "gapCount": 464}
