---
name: fairychar-coding-java
description: Use when writing, reviewing, or refactoring Java code in Fairychar Bag style or under fairychar-bag/src
---

# Fairychar Java 编码规范

## 核心原则

Fairychar Bag 的 Java 代码优先遵循本项目已有风格，而不是通用 Java 偏好。新增类前先确定模块性质和包位置，再选择命名、异常、Controller、Service、POJO、自动配置等细节规范。

## 渐进式加载

先读本文件；只有任务涉及对应主题时，再加载细分文档。

| 任务场景 | 继续加载 |
| --- | --- |
| 任意 Fairychar Java 编辑、审查、重构 | `reference/project-style.md` |
| 新增类、移动类、判断包路径 | `reference/package-structure.md` |
| 应用模块 Controller、Service、接口实现 | `reference/application-layer.md` |
| REST 返回、业务异常、错误码、`IRestErrorCode` | `reference/exception-response.md` |
| `fairychar-bag/src` 库代码、AOP、Bean、工具、模板 | `reference/library-style.md` |
| 常量、单例、POJO、Lombok、配置属性 | `reference/domain-pojo-properties.md` |
| Spring Boot 自动配置、条件 Bean、starter 能力 | `reference/auto-configuration.md` |
| 需要脱离项目查看原始样例 | `code/src/main/java/com/fairychar/bag/...` 或 `sample/...` |

## 必须先执行的判断

1. 判断目标是可复用库代码还是应用业务模块。
2. 新增 Java 类前，按 `reference/package-structure.md` 选择最窄职责包。
3. 涉及 REST 异常或错误码时，按 `reference/exception-response.md` 使用 `IRestErrorCode`。
4. 涉及应用层 Service 时，必须有 `service.interfaces.I*Service` 接口，`*Service` 实现该接口。
5. 涉及 Controller 时，必须保持薄控制器、`@RequestLog`、Swagger/OpenAPI、Knife4j 排序和 `HttpResult` 返回风格。

## 快速硬性规则

- 证据来源只限 `fairychar-bag/src`、本 skill 的 `code/` 快照和 `sample/` 样例；不要从兄弟模块或生成模板推导库代码风格。
- Java 基线为 Java 21、UTF-8、Spring Boot 3 风格。
- 新增类不要放进泛化包名：`service`、`manager`、`common`、`core`、`support`。应用模块已有 `controller/service/service.interfaces` 结构时除外。
- 保留项目命名：`I*` 接口、`*Query`、`*VO`、`*Properties`、`*Util`、`*Template`、`*Configurer`、`*AspectJ`、`*Handler`。
- REST 失败使用 `RestException`、`RestErrorCode` 或实现 `IRestErrorCode` 的领域错误码；响应使用 `HttpResult`。
- 错误码定义使用 enum 实现 `IRestErrorCode`，稳定暴露 `getCode()` 与 `getMessage()`，不要在 Service 中散落裸数字和裸消息。
- 可选 starter Bean 使用 `@ConditionalOnProperty`；可替换默认 Bean 使用 `@ConditionalOnMissingBean`。

## 验证

- 风格巡检：`powershell -ExecutionPolicy Bypass -File <skill-dir>/script/check-fairychar-style.ps1`
- 检查指定源码树：追加 `-Root <source-root>`
- 自动配置变更需确认 `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`
