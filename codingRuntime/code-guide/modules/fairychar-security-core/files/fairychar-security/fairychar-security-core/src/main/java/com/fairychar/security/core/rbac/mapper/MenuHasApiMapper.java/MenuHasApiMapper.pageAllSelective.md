# com.fairychar.security.core.rbac.mapper.MenuHasApiMapper.pageAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MenuHasApiMapper.java.md)

[Lexical owner](MenuHasApiMapper.md#symbol-854945b8d6d116a1)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-e19d86d0408288d5"></a>
## com.fairychar.security.core.rbac.mapper.MenuHasApiMapper.pageAllSelective

```java
Page<MenuHasApi> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") MenuHasApi menuHasApi)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/MenuHasApiMapper.java:68`; evidence: `declaration-e19d86d0408288d5a6063e1d103da8de1c7d432962b572f48b6980ed03d53337`.
Owner: `com.fairychar.security.core.rbac.mapper.MenuHasApiMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配分页查询MenuHasApi所有数据指定column

 @param page       分页参数
 @param menuHasApi {@see MenuHasApi}查询条件
 @return 查询结果 {@see MenuHasApi}
```
