# com.fairychar.security.core.rbac.service.SysMenuService

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysMenuService.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9d62f9ff3f7ec88c"></a>
## com.fairychar.security.core.rbac.service.SysMenuService

```java
@Service("sysMenuService")
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysMenuService.java:35`; evidence: `declaration-9d62f9ff3f7ec88c48ef4b7e66463a2c34595ca59bd272823983d8371a9e43ba`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
系统菜单(SysMenu)表服务实现类

 @author chiyo
```


## Fields

<a id="symbol-45dacc74fbb8274b"></a>
### sysMenuMapper

```java
@Autowired
private SysMenuMapper sysMenuMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysMenuService.java:37`; evidence: `declaration-45dacc74fbb8274b8f655ab0f6d5359567a646583db17e5c77e6c569fd139407`.
Visibility: `private` (explicit).
Type: `SysMenuMapper`.
No initializer recorded.

<a id="symbol-72c612563e19211c"></a>
### sysMenuStructure

```java
@Autowired
private SysMenuStructure sysMenuStructure
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysMenuService.java:39`; evidence: `declaration-72c612563e19211c87cfe17d173221dc36875684ea078af9edcce71c676af01b`.
Visibility: `private` (explicit).
Type: `SysMenuStructure`.
No initializer recorded.

## Members

- [pageByRoot](SysMenuService.pageByRoot.md#symbol-fb003a67d88e2275) — `function`, source line 48
- [save](SysMenuService.save.md#symbol-9b78ea411ea5291a) — `function`, source line 76
- [updateById](SysMenuService.updateById.md#symbol-7ee4fe3b19e6e601) — `function`, source line 102
- [findById](SysMenuService.findById.md#symbol-34551ae3e5519de3) — `function`, source line 120
- [saveBatch](SysMenuService.saveBatch.md#symbol-96804f8a29bc0f43) — `function`, source line 142
- [updateByIdBatch](SysMenuService.updateByIdBatch.md#symbol-95bc23344edc939d) — `function`, source line 175
