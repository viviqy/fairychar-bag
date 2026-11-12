# 请求上下文工具

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## RequestUtil

位置: `com.fairychar.bag.utils.RequestUtil`

```java
HttpServletRequest request = RequestUtil.getCurrentRequest();
HttpServletResponse response = RequestUtil.getCurrentResponse();
String ip = RequestUtil.getIpAddress(request);
Map<String, String> headers = RequestUtil.getHeader(request);

RequestUtil.putAttribute("userId", 1L);
Long userId = RequestUtil.getAttribute("userId", Long.class);
```

方法:

- `getHeader(HttpServletRequest)`: 返回所有 header 的 `LinkedHashMap`。
- `getCurrentRequest()`: 从 `RequestContextHolder` 获取当前请求，失败抛 `FBException`。
- `getCurrentResponse()`: 从 `RequestContextHolder` 获取当前响应，失败抛 `FBException`。
- `putAttribute(String, T)`: 写当前 request attribute。
- `getAttribute(String, Class<T>)`: 读当前 request attribute，不做类型校验，调用方必须保证实际类型。
- `getIpAddress(HttpServletRequest)`: 依次读取 `X-Forwarded-For`、`Proxy-Client-IP`、`WL-Proxy-Client-IP`、`HTTP_CLIENT_IP`、`X-Real-IP`，最后用 `getRemoteAddr()`。
- `obtainUri(MethodSignature)`: 从 Controller 类和方法的 Mapping 注解拼接 URI。

注意:

- `obtainUri` 假设 mapping 的 `value()[0]` 存在，空 mapping 可能异常。
- `getCurrentRequest/Response` 只能在请求线程使用。

## 输入、输出与失败

| 入口 | 输入与效果 | 失败、责任与边界 |
| --- | --- | --- |
| `getCurrentRequest/getCurrentResponse/putAttribute/getAttribute` | 绑定了 ServletRequestAttributes 的当前线程；读写当前 request 属性；不存在属性返回 null | 没有上下文或 response 时抛 `FBException`；不是 Servlet 上下文时可类型转换失败；`getAttribute` 的 Class 参数不执行运行时校验。请求结束或异步任务不能继续依赖该上下文 |
| `getHeader(request)` | 非 null 请求，返回新 LinkedHashMap；每个 header 只取 `getHeader` 的单个值 | 不保证包含多值 header 的所有值；不自动过滤令牌或密码，日志前由业务脱敏 |
| `getIpAddress(request)` | 按代理头优先、remoteAddr 兜底读取；逗号列表取第一个地址 | 不是可信客户端认证或 IP 授权机制；代理头可伪造，应由业务可信代理策略处理 |
| `RequestUtil.obtainUri(MethodSignature)` | 只拼接类和方法 mapping 的第一个 value，不进行占位符替换 | mapping 只有 path 或 value 为空数组时可越界；不是实际请求 URI，不用于权限匹配，业务优先读 request URI |

## 类型与完整签名

- [`com.fairychar.bag.utils.RequestUtil`](../../api/utils--requestutil.md)
