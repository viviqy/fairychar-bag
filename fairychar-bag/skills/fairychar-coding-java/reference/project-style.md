# Fairychar Java 项目风格总览

本文件是二级路由。进入具体编码前，只加载与当前任务相关的细分文档。

## 适用范围

- 主要证据：`fairychar-bag/src/main/java`、`fairychar-bag/src/main/resources`、`fairychar-bag/src/test`。
- 离线证据：本 skill 的 `code/src/main/java` 快照。
- 应用层样例：本 skill 的 `code/src/main/java/com/fairychar/bag/controller`、`code/src/main/java/com/fairychar/bag/service`、`code/src/main/java/com/fairychar/bag/service/interfaces`。
- 不要从兄弟模块、根目录文档、生成器模板反推 `fairychar-bag/src` 的库代码风格。

## 基础约束

- Java 21、UTF-8、Spring Boot 3。
- 常见依赖：Spring MVC、AOP、MyBatis-Plus、Redis、Netty、Lombok、Hutool、Guava、Jackson、Logback、Jakarta Validation。
- 不使用 tab。
- 目标行宽 140 列以内；已有长行不作为新增长行的理由。
- 代码块必须使用花括号。
- Javadoc 不强制铺满，公共 API 或不直观行为优先写简短中文说明。

## 按任务加载

| 当前要做什么 | 加载文档 |
| --- | --- |
| 新增类、判断类放在哪里、命名包结构 | `package-structure.md` |
| 写应用模块 Controller、Service、Service 接口 | `application-layer.md` |
| 写应用模块 MyBatis-Plus Mapper、XML SQL | `mybatis-plus-mapper.md` |
| 定义异常、错误码、REST 返回 | `exception-response.md` |
| 写 `fairychar-bag/src` 可复用库能力、AOP、Bean、工具、模板 | `library-style.md` |
| 写常量、单例、POJO、Lombok、配置属性 | `domain-pojo-properties.md` |
| 写 Spring Boot 自动配置、条件 Bean、starter 接入 | `auto-configuration.md` |

## 快速自检

- 新增类是否已经按职责选择最窄包，而不是放入 `common/core/manager/support`？
- Lombok 注解是否匹配类型职责，而不是为了省代码随意使用？
- 应用层 `*Service` 是否实现了 `service.interfaces.I*Service`？
- 应用层新增、更新、查询是否使用了场景化 `*Query`，且 Controller、Service 接口、Service 实现签名一致？
- Mapper 接口是否只声明方法，所有 SQL 是否都写在 XML mapper 中？
- 配置属性类是否统一放在 `configuration.properties`，并使用 `@NestedConfigurationProperty` 表达嵌套配置？
- Controller 是否有 `@RequestLog`、`@Operation`、`@ApiOperationSupport(order = ...)`？
- REST 错误码是否通过 enum 实现 `IRestErrorCode`？
- 可选 Bean 是否有条件开关，默认 Bean 是否允许用户覆盖？

## 样例入口

- 应用 Controller：`code/src/main/java/com/fairychar/bag/controller/PermissionPolicyController.java`
- 应用 Service：`code/src/main/java/com/fairychar/bag/service/PermissionPolicyService.java`
- 应用 Service 接口：`code/src/main/java/com/fairychar/bag/service/interfaces/IPermissionPolicyService.java`
- 应用 Mapper：`code/src/main/java/com/fairychar/bag/mapper/SysDictMapper.java`
- Mapper XML：`code/src/resources/mapper/SysDictMapper.xml`
- 库代码快照：`code/src/main/java/com/fairychar/bag/...`
