# MyBatis 字段加解密

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## AES/RSA TypeHandler

位置:

- `com.fairychar.bag.beans.mybatis.handler.AesTypeHandler`
- `com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler`

配置 AES/RSA Bean:

```yaml
fairychar:
  bag:
    secret:
      aes:
        key: "1234567890123456"
      rsa:
        pub-key: "..."
        pri-key: "..."
```

实体字段:

```java
@TableField(typeHandler = AesTypeHandler.class)
private String phone;

@TableField(typeHandler = RsaTypeHandler.class)
private String idCard;
```

静态工具:

```java
String cipher = AesTypeHandler.encryptHex("hello");
String plain = AesTypeHandler.decrypt(cipher);

String rsaCipher = RsaTypeHandler.encryptBase64("hello");
String rsaPlain = RsaTypeHandler.decrypt(rsaCipher);
```

注意:

- `AesTypeHandler` 和 `RsaTypeHandler` 内部依赖静态 `aes/rsa` 字段，使用前必须确保已注入或手动 `setAes/setRsa`。
- `AesTypeHandler` 入库使用 `encryptHex`，出库 `decryptStr`。
- `RsaTypeHandler` 入库用公钥，出库用私钥。

## 输入、效果与失败契约

**前置与输入**：注册到实际 Mapper/字段并确保读取映射也使用 handler；AES/RSA 静态状态必须在处理非空值前初始化。仅容器中存在同类型 Bean 不应当作静态 handler 已就绪的证明；业务启动时可用公开 setter 明确设置，密钥使用业务安全配置，不复制示例密钥。

**效果与返回**：AES 非空字符串入库为 hex，读取时解密；AES 的空字符串入库仍调用 setString 写空字符串，读取空字符串仍为 `""`。RSA 非空字符串用公钥加密为 Base64，读取用私钥解密；RSA 的 `setNonNullParameter` 收到空字符串时不会调用 setString，读到 null 或空字符串均返回 null。不要按 AES 行为推断 RSA 空值行为。

**失败**：handler 中加解密异常包装 SQLException；ResultSet 自身异常按 JDBC 传播。静态 encrypt/decrypt 工具不走 JDBC 包装，未初始化时可 NPE，错误密钥/密文可抛加解密运行异常。不要向终端暴露密钥或原始加密异常。

**副作用与资源**：写 PreparedStatement 参数，读 ResultSet，不负责连接关闭、事务或密钥轮换；全局静态算法对象会影响所有 handler 实例。禁止请求级改密钥；跨租户动态密钥不能直接依赖此全局状态。

**最小验证**：对业务选定列做非空往返、null/空字符串、损坏密文、错误密钥和读取映射测试；空字符串有语义时不要直接采用 RSA handler。这不是认证、密码散列或端到端加密方案。

## 类型与完整签名

- [`com.fairychar.bag.beans.mybatis.handler.AesTypeHandler`](../../api/beans-mybatis-handler.md)
- [`com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler`](../../api/beans-mybatis-handler.md)
