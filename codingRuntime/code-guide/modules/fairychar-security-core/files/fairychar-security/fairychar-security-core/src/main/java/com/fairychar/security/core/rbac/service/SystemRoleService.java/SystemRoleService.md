# com.fairychar.security.core.rbac.service.SystemRoleService

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemRoleService.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5f1752eb668845ab"></a>
## com.fairychar.security.core.rbac.service.SystemRoleService

```java
@Service("systemRoleService")
public class SystemRoleService extends ServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SystemRoleService.java:32`; evidence: `declaration-5f1752eb668845abaa7462a7451fdaa4787447734beec2526a3e9e49103786a7`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色表(SystemRole)表服务实现类

 @author chiyo
```


## Fields

<a id="symbol-870b106ff5e95b9d"></a>
### systemRoleMapper

```java
@Autowired
private SystemRoleMapper systemRoleMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SystemRoleService.java:34`; evidence: `declaration-870b106ff5e95b9d21c4e1967f37525b3a46fb0afe47e6f47e1437d92d6fe8e4`.
Visibility: `private` (explicit).
Type: `SystemRoleMapper`.
No initializer recorded.

<a id="symbol-7f949b12205592c0"></a>
### systemRoleStructure

```java
@Autowired
private SystemRoleStructure systemRoleStructure
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SystemRoleService.java:36`; evidence: `declaration-7f949b12205592c0b62cfc7b224dad118b6185172177268bd31c5903c9031d11`.
Visibility: `private` (explicit).
Type: `SystemRoleStructure`.
No initializer recorded.

## Members

- [pageByRoot](SystemRoleService.pageByRoot.md#symbol-55b6459215fd712e) — `function`, source line 45
- [save](SystemRoleService.save.md#symbol-260ab2e77d731b5f) — `function`, source line 62
- [updateById](SystemRoleService.updateById.md#symbol-fdb97c5a85ef4b08) — `function`, source line 83
- [findById](SystemRoleService.findById.md#symbol-cff0416788462532) — `function`, source line 101
- [saveBatch](SystemRoleService.saveBatch.md#symbol-dc617a335b776ea5) — `function`, source line 113
- [updateByIdBatch](SystemRoleService.updateByIdBatch.md#symbol-7ff6579f2bbd1ce3) — `function`, source line 146
