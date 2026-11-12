# 请求体缓存与请求包装

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 请求包装不是完整克隆

`new ClonedServletRequest(request)` 会立即读取整个输入流到内存。它覆写了 method、URI、请求 sessionId、部分 header/attribute 和输入流读取；其他方法仍可能委托原请求。

- 输入体大小必须由业务限制，不能无界缓存上传文件或大请求。
- `getInputStream()` 每次创建新输入流，但依赖 Tomcat `InputBuffer` / `CoyoteInputStream`。
- header 缓存只保存 `getHeader(name)` 的单值，不保留多值 header 的完整语义。
- 不要将该对象跨线程、跨请求生命周期保存；它不是可安全离线传输的请求快照。
- 构造时读取输入流的异常被忽略，后续读取并不因此保证成功；`getReader()` 与继承方法也不能推断为完全支持重复读取。

`EmptyServletRequest` 是占位对象，许多方法返回 null、0 或 false，不是完整请求模拟器。

## 类型与完整签名

- [`com.fairychar.bag.extension.request.CloneServletInputStream`](../../api/extension-request.md)
- [`com.fairychar.bag.extension.request.ClonedServletRequest`](../../api/extension-request.md)
- [`com.fairychar.bag.extension.request.EmptyServletRequest`](../../api/extension-request.md)
