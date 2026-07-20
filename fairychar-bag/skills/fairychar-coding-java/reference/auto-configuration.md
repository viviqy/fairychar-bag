# 自动配置与条件 Bean 规范

适用于 Spring Boot starter 能力、可选 Bean、默认 Bean、配置属性接入。

## 基本结构

- 自动配置集中在 `configurer` 包。
- `BagBeansAutoConfigurer` 按功能组织嵌套 `protected static` 配置类。
- 新增顶层自动配置类时，必须注册到 `fairychar-bag/src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`。
- 配置属性通过 `@EnableConfigurationProperties(FairycharBagProperties.class)` 接入。

## 条件规则

- 可选功能必须使用 `@ConditionalOnProperty`。
- 默认实现必须使用 `@ConditionalOnMissingBean`，允许使用方覆盖。
- 条件开关优先绑定 `fairychar.bag.<feature>.<name>.enable` 这类已有风格。
- 需要按环境或平台启用时，优先复用项目已有条件注解，例如 `ConditionalOnSystemOS`。
- 不要新增无条件 Bean，除非它是极小且无副作用的基础能力，并且已有附近配置也是无条件。

## Bean 设计

- 可替换技术集成 Bean 放 `beans.<technology>`，自动配置只负责装配。
- 配置属性类只表达配置，不承载复杂初始化逻辑。
- Bean 初始化参数来自 `FairycharBagProperties` 下的功能配置。
- 有多个实现时，使用明确 Bean name 或配置项选择，不在业务代码中硬编码实现。
- 默认 Bean 的依赖也应尽量可替换。

## 新增配置属性接入流程

1. 在 `configuration.properties` 下新增或扩展 `*Properties`。
2. 如需挂到根配置，将字段加入 `FairycharBagProperties`。
3. 在自动配置类中读取配置属性。
4. 用 `@ConditionalOnProperty` 控制是否启用。
5. 用 `@ConditionalOnMissingBean` 保护默认 Bean。
6. 如果新增顶层自动配置类，更新 `AutoConfiguration.imports`。

## 验证

- 检查条件开关默认行为是否符合现有配置约定。
- 检查用户是否能通过自定义 Bean 覆盖默认实现。
- 检查自动配置类是否被 imports 文件加载。

## 样例

- `code/src/main/java/com/fairychar/bag/configurer/BagBeansAutoConfigurer.java`
- `code/src/main/java/com/fairychar/bag/configuration/properties/FairycharBagProperties.java`
- `code/src/main/java/com/fairychar/bag/configuration/properties/AopProperties.java`
