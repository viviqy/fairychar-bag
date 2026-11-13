# com.fairychar.bag.beans.mybatis.handler.AesTypeHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AesTypeHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-25ff445044deff41"></a>
## com.fairychar.bag.beans.mybatis.handler.AesTypeHandler

```java
public class AesTypeHandler extends BaseTypeHandler<String>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/handler/AesTypeHandler.java:22`; evidence: `declaration-25ff445044deff4133c748d5757cf5f8ec9d0e3eb180773da79662f8ee4ddf4e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>mybatis aes typeHandler{@link org.apache.ibatis.type.TypeHandler}</p>
 <p>在数据入库前会先aes加密,查询出库后解密</p>

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-9774838f886df251"></a>
### aes

```java
@Setter
private static AES aes
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/handler/AesTypeHandler.java:24`; evidence: `declaration-9774838f886df25115dcc0431df01000e818452d9299f2e33340b58f80869df3`.
Visibility: `private` (explicit).
Type: `AES`.
No initializer recorded.

## Members

- [setNonNullParameter](AesTypeHandler.setNonNullParameter.md#symbol-78864b60ab233930) — `function`, source line 28
- [getNullableResult](AesTypeHandler.getNullableResult--bf8ad4824c480036.md#symbol-e189f4d76f048b2c) — `function`, source line 41
- [getNullableResult](AesTypeHandler.getNullableResult--06f7298aec61f38f.md#symbol-73c36804086593bc) — `function`, source line 54
- [getNullableResult](AesTypeHandler.getNullableResult--70f5925b11ccf50a.md#symbol-ef7d2aabade7e8b1) — `function`, source line 67
- [encryptHex](AesTypeHandler.encryptHex.md#symbol-444bb2479a43efb4) — `function`, source line 80
- [encryptBase64](AesTypeHandler.encryptBase64.md#symbol-4d6cdd79eee9fb82) — `function`, source line 84
- [decrypt](AesTypeHandler.decrypt.md#symbol-b9852ceedd0e64d5) — `function`, source line 88
