# com.fairychar.security.core.rbac.service.SysApiService

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiService.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-15dd153bd489c3b6"></a>
## com.fairychar.security.core.rbac.service.SysApiService

```java
@Service("sysApiService")
public class SysApiService extends ServiceImpl<SysApiMapper, SysApi> implements ISysApiService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:35`; evidence: `declaration-15dd153bd489c3b66ee9f91ffd970ec07ae69de7572888039a14b81654053621`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(SysApi)表服务实现类

 @author chiyo
```


## Fields

<a id="symbol-7564099f76111524"></a>
### sysApiMapper

```java
@Autowired
private SysApiMapper sysApiMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:37`; evidence: `declaration-7564099f7611152465c3ab453f9fc1c14be0d8581a9ba4af094736ec7e618c40`.
Visibility: `private` (explicit).
Type: `SysApiMapper`.
No initializer recorded.

<a id="symbol-21c64f99a177b95c"></a>
### sysApiStructure

```java
@Autowired
private SysApiStructure sysApiStructure
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:39`; evidence: `declaration-21c64f99a177b95cdf96b339f9bbd6a14bb9e78902f6e3d557cd656fabf68188`.
Visibility: `private` (explicit).
Type: `SysApiStructure`.
No initializer recorded.

<a id="symbol-f691709592385aed"></a>
### menuHasApiService

```java
@Autowired
private IMenuHasApiService menuHasApiService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysApiService.java:41`; evidence: `declaration-f691709592385aed01c5c792653f28de55af3325fd2968f665843599c91f9ee5`.
Visibility: `private` (explicit).
Type: `IMenuHasApiService`.
No initializer recorded.

## Members

- [pageAll](SysApiService.pageAll.md#symbol-66616bcdd12ba8d4) — `function`, source line 51
- [save](SysApiService.save.md#symbol-91edaf7e61e9096a) — `function`, source line 66
- [updateById](SysApiService.updateById.md#symbol-5e3f1c43795743d2) — `function`, source line 89
- [findById](SysApiService.findById.md#symbol-f49040bf45fa6ba8) — `function`, source line 109
- [saveBatch](SysApiService.saveBatch.md#symbol-9100e5481975317f) — `function`, source line 121
- [updateByIdBatch](SysApiService.updateByIdBatch.md#symbol-b76a692696f6677d) — `function`, source line 154
- [removeBatch](SysApiService.removeBatch.md#symbol-3772736c9c7cd395) — `function`, source line 189
