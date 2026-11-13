# com.fairychar.security.core.rbac.service.MenuHasApiService

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MenuHasApiService.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-63ac75ff5837416c"></a>
## com.fairychar.security.core.rbac.service.MenuHasApiService

```java
@Service("menuHasApiService")
public class MenuHasApiService extends ServiceImpl<MenuHasApiMapper, MenuHasApi> implements IMenuHasApiService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/MenuHasApiService.java:27`; evidence: `declaration-63ac75ff5837416c699c0a6ce28cd6c67dd0422cf22dbede5033d3e10bd4b09d`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(MenuHasApi)表服务实现类

 @author chiyo
```


## Fields

<a id="symbol-cf75483df21099ee"></a>
### menuHasApiMapper

```java
@Autowired
private MenuHasApiMapper menuHasApiMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/MenuHasApiService.java:29`; evidence: `declaration-cf75483df21099ee801a3bc6cd96ca50d9672808362f05a40aacaf55c9aad94a`.
Visibility: `private` (explicit).
Type: `MenuHasApiMapper`.
No initializer recorded.

<a id="symbol-efc42ef40f76838a"></a>
### menuHasApiStructure

```java
@Autowired
private MenuHasApiStructure menuHasApiStructure
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/MenuHasApiService.java:31`; evidence: `declaration-efc42ef40f76838aed4361ad18e7ea0d875c16353fbaa4dd0e2425777dc3b810`.
Visibility: `private` (explicit).
Type: `MenuHasApiStructure`.
No initializer recorded.

## Members

- [pageAll](MenuHasApiService.pageAll.md#symbol-97daec8c5204136c) — `function`, source line 34
- [save](MenuHasApiService.save.md#symbol-69349ccfd74f92d2) — `function`, source line 50
- [saveBatch](MenuHasApiService.saveBatch.md#symbol-2b283d2a86f954cc) — `function`, source line 72
- [removeBatch](MenuHasApiService.removeBatch.md#symbol-5d63f897a477b20b) — `function`, source line 90
- [removeByMenuIds](MenuHasApiService.removeByMenuIds.md#symbol-c65d14edecd9cf16) — `function`, source line 99
