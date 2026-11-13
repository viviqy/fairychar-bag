# com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RsaTypeHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-09bfe28478a0311b"></a>
## com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler

```java
public class RsaTypeHandler extends BaseTypeHandler<String>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/handler/RsaTypeHandler.java:23`; evidence: `declaration-09bfe28478a0311b107dc7e52eb8dc0e57dc22d18f58b07a8b6be9086b839eed`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>mybatis aes typeHandler{@link org.apache.ibatis.type.TypeHandler}</p>
 <p>在数据入库前会先rsa加密,查询出库后解密</p>

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-b68410f63d0e5e54"></a>
### rsa

```java
@Setter
private static RSA rsa
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/handler/RsaTypeHandler.java:25`; evidence: `declaration-b68410f63d0e5e5485be231bc9bdfbfcc471ceb15ced5b94b947822ed5dabd60`.
Visibility: `private` (explicit).
Type: `RSA`.
No initializer recorded.

## Members

- [setNonNullParameter](RsaTypeHandler.setNonNullParameter.md#symbol-262e38b31d71bb74) — `function`, source line 29
- [getNullableResult](RsaTypeHandler.getNullableResult--8d88b8ac7eb57b63.md#symbol-24a0d7ea4a7f006e) — `function`, source line 40
- [getNullableResult](RsaTypeHandler.getNullableResult--2119f4c2f949dbe9.md#symbol-3e90cb04e8798808) — `function`, source line 53
- [getNullableResult](RsaTypeHandler.getNullableResult--da46a4f3200e3a3f.md#symbol-ca5a333524f61b57) — `function`, source line 66
- [encryptBase64](RsaTypeHandler.encryptBase64.md#symbol-35123978d9d202b1) — `function`, source line 80
- [decrypt](RsaTypeHandler.decrypt.md#symbol-3cb018a0f573a575) — `function`, source line 84
