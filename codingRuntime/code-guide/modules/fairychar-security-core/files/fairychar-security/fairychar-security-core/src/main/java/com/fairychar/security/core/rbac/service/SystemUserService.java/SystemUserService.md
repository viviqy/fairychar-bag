# com.fairychar.security.core.rbac.service.SystemUserService

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemUserService.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3d18f01dd5f00664"></a>
## com.fairychar.security.core.rbac.service.SystemUserService

```java
@Service("systemUserService")
public class SystemUserService extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SystemUserService.java:23`; evidence: `declaration-3d18f01dd5f0066401946f4e95ec6a87f1caa2ea5d419b2a50c45d5c9feec20c`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
系统用户(SystemUser)表服务实现类

 @author chiyo
```


## Fields

<a id="symbol-17666d520738916f"></a>
### systemUserMapper

```java
@Autowired
private SystemUserMapper systemUserMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SystemUserService.java:25`; evidence: `declaration-17666d520738916f272f1104c3b05c23d81469df4a1764a19d9a0edad3f0300b`.
Visibility: `private` (explicit).
Type: `SystemUserMapper`.
No initializer recorded.

<a id="symbol-d338fc41150dc25f"></a>
### systemUserStructure

```java
@Autowired
private SystemUserStructure systemUserStructure
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SystemUserService.java:27`; evidence: `declaration-d338fc41150dc25ffe6f63040eab3cb3e8537701644601334c1e945e99d3ac22`.
Visibility: `private` (explicit).
Type: `SystemUserStructure`.
No initializer recorded.

## Members

- [findOne](SystemUserService.findOne.md#symbol-197960ee68799910) — `function`, source line 35
- [queryAll](SystemUserService.queryAll.md#symbol-b08d2d0754563b6b) — `function`, source line 47
- [pageAll](SystemUserService.pageAll.md#symbol-00d9b50b1b06d6ad) — `function`, source line 59
- [save](SystemUserService.save.md#symbol-e15827ba185256eb) — `function`, source line 74
- [updateById](SystemUserService.updateById.md#symbol-5de226c5901bfd7d) — `function`, source line 85
- [page](SystemUserService.page.md#symbol-3ab81567e9e11fd8) — `function`, source line 96
- [count](SystemUserService.count.md#symbol-3da2fa5e088211bc) — `function`, source line 107
- [findById](SystemUserService.findById.md#symbol-41c97b43f72297f1) — `function`, source line 118
- [saveBatch](SystemUserService.saveBatch.md#symbol-bd7570b84736c0e1) — `function`, source line 129
- [findAll](SystemUserService.findAll.md#symbol-733acfbba64fb8dc) — `function`, source line 141
