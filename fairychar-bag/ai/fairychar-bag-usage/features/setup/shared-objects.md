# 全局共享对象 Singletons

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## Singletons

位置: `com.fairychar.bag.domain.Singletons`

用途: 给非 Spring 管理的工具代码提供少量全局复用对象。优先使用 Spring Bean；只有工具类、静态方法或无法注入 Bean 的场景才使用 `Singletons`。

使用规则:

- 业务 Service、Controller、Repository 中优先注入 Spring Bean，不要因为方便而绕过依赖注入。
- `RestTemplateBean` 返回的是裸 `RestTemplate`，没有超时、拦截器、连接池、错误处理配置；生产 HTTP 调用优先使用业务自定义 Bean。
- `RandomBean` 返回 `java.util.Random`，不是密码学安全随机数；生成 token、密钥、验证码种子时不要使用它。
- `JsonBean` 的 `ObjectMapper` 是项目工具默认 JSON 配置，适合工具类序列化；接口响应仍优先交给 Spring MVC 的 Jackson 配置。

| 内部类 | 入口方法 | 返回类型 | 配置 / 行为 | 适用场景 |
| --- | --- | --- | --- | --- |
| `RestTemplateBean` | `Singletons.RestTemplateBean.getInstance()` | `RestTemplate` | 直接 `new RestTemplate()`，无额外配置 | 工具类里临时发起简单 HTTP 请求；更复杂请求应改为注入业务配置后的 `RestTemplate` |
| `RandomBean` | `Singletons.RandomBean.getInstance()` | `Random` | `new Random(System.currentTimeMillis())` | 非安全随机数，如简单抽样、测试随机数据 |
| `PathMatcherBean` | `Singletons.PathMatcherBean.getInstance()` | `AntPathMatcher` | 直接 `new AntPathMatcher()` | 静态工具中做 Ant 风格路径匹配 |
| `GsonBean` | `Singletons.GsonBean.getInstance()` | `Gson` | 直接 `new Gson()` | 简单 JSON 转换；需要统一日期、null、JavaTime 策略时优先用 `JsonBean` 或业务 ObjectMapper |
| `JsonBean` | `Singletons.JsonBean.getInstance()` | `tools.jackson.databind.ObjectMapper` | `JsonMapper.builder()`；默认属性包含策略为 ALWAYS；关闭空 Bean 失败；日期格式 `yyyy-MM-dd HH:mm:ss`；忽略未知属性 | 工具类 JSON 序列化/反序列化；具体 Java Time 输出格式应在所用 JAR 上断言 |

当前实现没有显式注册旧版 `JavaTimeModule`，也没有显式配置日期 timestamp 开关；不要据此推断所有 Java Time 类型都遵循 `Date` 的格式。各 singleton 是共享可变对象，业务不要临时更改它们的全局配置。

## 类型与完整签名

- [`com.fairychar.bag.domain.Singletons.GsonBean`](../../api/domain.md)
- [`com.fairychar.bag.domain.Singletons.JsonBean`](../../api/domain.md)
- [`com.fairychar.bag.domain.Singletons.PathMatcherBean`](../../api/domain.md)
- [`com.fairychar.bag.domain.Singletons.RandomBean`](../../api/domain.md)
- [`com.fairychar.bag.domain.Singletons.RestTemplateBean`](../../api/domain.md)
- [`com.fairychar.bag.domain.Singletons`](../../api/domain.md)
