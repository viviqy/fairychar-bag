# com.fairychar.security.core.rbac.mapper.MenuHasApiMapper.queryAllSelective

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MenuHasApiMapper.java.md)

[Lexical owner](MenuHasApiMapper.md#symbol-854945b8d6d116a1)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-e4a359bf498ed938"></a>
## com.fairychar.security.core.rbac.mapper.MenuHasApiMapper.queryAllSelective

```java
List<MenuHasApi> queryAllSelective(@Param("fields") String[] fields, @Param("e") MenuHasApi menuHasApi)
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/mapper/MenuHasApiMapper.java:50`; evidence: `declaration-e4a359bf498ed938a28a5aa1678adda3c90a6f33c8aa92241607c923b8c3f928`.
Owner: `com.fairychar.security.core.rbac.mapper.MenuHasApiMapper`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
条件匹配查询MenuHasApi所有数据指定column

 @param menuHasApi {@see MenuHasApi}查询条件
 @return 查询结果 {@see MenuHasApi}
```
