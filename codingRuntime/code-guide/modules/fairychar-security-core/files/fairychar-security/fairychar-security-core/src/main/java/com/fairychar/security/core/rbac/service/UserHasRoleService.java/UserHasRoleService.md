# com.fairychar.security.core.rbac.service.UserHasRoleService

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UserHasRoleService.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-fb990d21bc603f3f"></a>
## com.fairychar.security.core.rbac.service.UserHasRoleService

```java
@Service("userHasRoleService")
public class UserHasRoleService extends ServiceImpl<UserHasRoleMapper, UserHasRole> implements IUserHasRoleService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/UserHasRoleService.java:27`; evidence: `declaration-fb990d21bc603f3fe53954268fa369398aaf4e11e59f9ae6e6b967ad1daa2612`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
用户角色关联(UserHasRole)表服务实现类

 @author chiyo
```


## Fields

<a id="symbol-a3328325896f9a1f"></a>
### userHasRoleMapper

```java
@Autowired
private UserHasRoleMapper userHasRoleMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/UserHasRoleService.java:29`; evidence: `declaration-a3328325896f9a1f3baf8674a50bb3ab3aea226323bacf09fc0fd8a24814916f`.
Visibility: `private` (explicit).
Type: `UserHasRoleMapper`.
No initializer recorded.

<a id="symbol-b173d3e40f84ea35"></a>
### userHasRoleStructure

```java
@Autowired
private UserHasRoleStructure userHasRoleStructure
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/UserHasRoleService.java:31`; evidence: `declaration-b173d3e40f84ea357a2cb2a7daf66aac54fa5b71eb73c60028a6c2bda9cb63c7`.
Visibility: `private` (explicit).
Type: `UserHasRoleStructure`.
No initializer recorded.

## Members

- [pageAll](UserHasRoleService.pageAll.md#symbol-17ba409086b7fbe2) — `function`, source line 34
- [save](UserHasRoleService.save.md#symbol-011f209d40bdaf31) — `function`, source line 50
- [saveBatch](UserHasRoleService.saveBatch.md#symbol-33ac174fa3208bcc) — `function`, source line 72
- [removeBatch](UserHasRoleService.removeBatch.md#symbol-d313a6588a535d98) — `function`, source line 90
- [removeByUserIds](UserHasRoleService.removeByUserIds.md#symbol-f6c85456f8782b66) — `function`, source line 99
