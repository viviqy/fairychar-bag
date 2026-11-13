# com.fairychar.security.core.rbac.service.SysDictService

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysDictService.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-88c0487c595354b9"></a>
## com.fairychar.security.core.rbac.service.SysDictService

```java
@Service("sysDictService")

public class SysDictService extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysDictService.java:30`; evidence: `declaration-88c0487c595354b9d923391c2c027dd22f832674bfadca9d1072b8e9b319b340`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
数据字典详情(SysDict)表服务实现类

 @author chiyo
```


## Fields

<a id="symbol-a2a48ae486ee6106"></a>
### sysDictMapper

```java
@Autowired
private SysDictMapper sysDictMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysDictService.java:33`; evidence: `declaration-a2a48ae486ee610691bf1060f53e19be9c5a64b21ec8ea3aa2781d59bccdf29b`.
Visibility: `private` (explicit).
Type: `SysDictMapper`.
No initializer recorded.

<a id="symbol-3e706e587fa335de"></a>
### sysDictStructure

```java
@Autowired
private SysDictStructure sysDictStructure
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/service/SysDictService.java:35`; evidence: `declaration-3e706e587fa335deeb9e2856bd64915111c5f67f23ec056e99895b3ac9a59d46`.
Visibility: `private` (explicit).
Type: `SysDictStructure`.
No initializer recorded.

## Members

- [pageAll](SysDictService.pageAll.md#symbol-c15f478056fb85eb) — `function`, source line 45
- [save](SysDictService.save.md#symbol-a47689fc5f2384fa) — `function`, source line 61
- [updateById](SysDictService.updateById.md#symbol-6434bed1c3f99762) — `function`, source line 83
- [findById](SysDictService.findById.md#symbol-3e79b2f1ec82dd95) — `function`, source line 100
