# com.fairychar.security.core.rbac.service.RoleHasMenuService

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RoleHasMenuService.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-bd96c770f61517ce"></a>
## com.fairychar.security.core.rbac.service.RoleHasMenuService

```java
@Service("roleHasMenuService")
public class RoleHasMenuService extends ServiceImpl<RoleHasMenuMapper, RoleHasMenu> implements IRoleHasMenuService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/RoleHasMenuService.java:27`; evidence: `declaration-bd96c770f61517ce71e8a97ec86dd7b36b4b959e144d47a385a9bbe6bdc7f576`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色菜单关联(RoleHasMenu)表服务实现类

 @author chiyo
```


## Fields

<a id="symbol-f89f3157490a0a11"></a>
### roleHasMenuMapper

```java
@Autowired
private RoleHasMenuMapper roleHasMenuMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/RoleHasMenuService.java:29`; evidence: `declaration-f89f3157490a0a116a12bb4ceffa140a7fd5519d12a5eb1b9f56dcbce72ebfe1`.
Visibility: `private` (explicit).
Type: `RoleHasMenuMapper`.
No initializer recorded.

<a id="symbol-e8a5915c907fd598"></a>
### roleHasMenuStructure

```java
@Autowired
private RoleHasMenuStructure roleHasMenuStructure
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/RoleHasMenuService.java:31`; evidence: `declaration-e8a5915c907fd598208823719c740d9540545f7e9bb9d707385e4b610ab84fb2`.
Visibility: `private` (explicit).
Type: `RoleHasMenuStructure`.
No initializer recorded.

## Members

- [pageAll](RoleHasMenuService.pageAll.md#symbol-0323ee73c107abcb) — `function`, source line 34
- [save](RoleHasMenuService.save.md#symbol-6cb2729fe567acab) — `function`, source line 50
- [saveBatch](RoleHasMenuService.saveBatch.md#symbol-de268f733806d9b5) — `function`, source line 72
- [removeBatch](RoleHasMenuService.removeBatch.md#symbol-88f177cfd549c74a) — `function`, source line 90
- [removeByRoleIds](RoleHasMenuService.removeByRoleIds.md#symbol-5b4de2b1e7e9188f) — `function`, source line 99
