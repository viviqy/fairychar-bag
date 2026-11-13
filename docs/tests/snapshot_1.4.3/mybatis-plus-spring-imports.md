# MyBatis-Plus ServiceImpl 等类型导入问题

- 日期：2026-11-13；原始 Git 分支：`snapshot/1.4.3`。
- 范围：父 POM 的版本管理、security core 的 MyBatis-Plus 模块依赖、RBAC 继承兼容回归与 IDE 同步说明。

## 根因与修复边界

实际检查本地 MyBatis-Plus 3.5.16 JAR：`ServiceImpl`、`IService` 和 ActiveRecord `Model` 位于 `mybatis-plus-spring`，而不是仅依赖 `mybatis-plus-extension` 就能获得。Java 包名未改变，不应批量替换现有 import 或继承关系。

前序迁移已在工作区补入模块，但其 POM 修正尚未提交。当前固化父 POM 对 `mybatis-plus-spring` 的统一版本管理，以及 security core 对 `mybatis-plus-spring`、`mybatis-plus-jsqlparser` 的直接编译依赖；不依赖宿主 starter 或其他模块的 provided 依赖间接提供。

IDE 工程依赖快照中有 `mybatis-plus-extension-3.5.16.jar`，却没有 `mybatis-plus-spring`。IDE 定向构建仍复现 IService、ServiceImpl、Model 缺失。因此还需要重新加载 Maven 模型，而不是只执行 Build。IDE 使用自定义 Maven、本地仓库和 settings，与终端默认配置不同；不能只凭默认终端编译通过就认定 IDE 已恢复。

## 验证

新增 `MybatisPlusSpringCompatibilityTest` 三项测试，检查八个 RBAC Service、八个 Service 接口和八个实体分别能解析并继承 ServiceImpl、IService 和 Model。

- 使用实际测试 classpath，单独移除 `mybatis-plus-spring` 后三项均失败，出现 MyBatis-Plus 类型的 NoClassDefFoundError；恢复原 classpath 后三项通过。未修改项目 POM 或删除缓存来复现。
- 默认终端 Maven：security reactor 清理后重新编译、打包及依赖树检查通过；本次三项加既有 45 项共 48 项通过，失败、错误、跳过均为 0。
- 依赖树确认 `com.baomidou:mybatis-plus-spring:3.5.16:compile`，starter 消费 core 时也可传递获得该模块。
- 使用 IDEA 实际配置的 Maven 3.8.3、settings 和本地仓库执行根 reactor `clean compile -Dmaven.test.skip=true -Dflatten.skip=true -Dmaven.source.skip=true`：8 个项目全部编译通过，不是只复用旧 class 文件。
- 同一 IDEA 配置执行完整测试的离线尝试因缺少 H2 2.4.240 的对应仓库缓存失败；联网尝试停留在 repo1 下载 H2，已中止本次验证进程，未更改用户仓库或全局 Maven 设置。不将该环境的完整测试记为通过。
- 风格检查无 Tab，core 历史超过 140 列告警仍为 14，无新增。
- 本次只变更依赖、测试与文档，无生产 Java 变化，导航 freshness 仍为 current，继续沿用现有正式快照。

默认终端复现命令：

```powershell
mvn -o -pl fairychar-security/fairychar-security-boot-starter -am clean package dependency:tree '-DskipTests=false' '-Dflatten.skip=true' '-Dmaven.source.skip=true' '-Dtest=MybatisPlusSpringCompatibilityTest,EffectiveApiPermissionsTest,InMemCodeVerifierTest,JsonAuthenticationFilterTest,SpringBoot4CompatibilityTest,JsonResponseCompatibilityTest' '-Dsurefire.failIfNoSpecifiedTests=false' '-Dincludes=com.baomidou:*'
```

本地日志位于忽略目录 `codingRuntime/code-guide-work/boot4-validation/`，文件名以 `mp-` 开头。验证基于包含前序未提交 Boot 4 迁移的当前工作区；本次提交不混入 Jackson 迁移、测试跳过策略等其他 POM 改动。

## IDE 尚需完成的操作

1. 在 Maven 工具窗口执行“重新加载所有 Maven 项目”，不是只执行 Build，也不是仅下载源码。
2. 等待导入完成，确认 External Libraries 或模块依赖中出现 `mybatis-plus-spring-3.5.16`，再编译。
3. 如果重新导入提示 H2 下载失败，需允许 IDEA 所用仓库完成测试依赖下载；本次没有擅自修改全局镜像或本地仓库位置。

尝试通过 UI 操作重载时窗口截图超时、无可用控件坐标，无法可靠执行重载，已提示用户手动操作。随后 IDE 模型已更新：`get_symbol_info` 将 ServiceImpl 正确解析到 `mybatis-plus-spring-3.5.16-sources.jar`；SysApiService 错误检查为空；最后执行 IDEA `build_project(rebuild=true)` 全量重建通过，仅有既有 MapStruct、弃用 API 等警告。该结果覆盖了早期 IDE 定向构建失败的状态，无需降级依赖或删除 `.idea`。

## 剩余开发项

- R1 是宿主认证扩展点，不作为缺口；R2 聚合已完成。
- R3 认证对象权限装载；R4 权限过滤器装配；R5 方法通配符与混合权限类型边界仍待处理。
- R6 账户管理安全边界、R7 在线撤权联动待处理；R8／R9 装配和管理接口职责待明确；R10 更广泛目标数据库及端到端鉴权验证未完成。
- 非 RBAC：多租户插件组合、JSON 登录字段校验、解密异常分类、后置处理器契约、真实外部服务集成验证。
