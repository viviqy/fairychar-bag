# R2 用户有效 API 权限聚合验证

- 日期：2026-11-13；原始 Git 分支：`snapshot/1.4.3`。
- 方案与调用契约：[R2 方案](../../technical/snapshot_1.4.3/rbac-effective-api-permissions.md)。
- R1 按用户明确要求保留为宿主认证扩展点，不再列为缺口。

## 实现范围

新增 `ISysApiService.listEffectiveByUserUid(Long)`，通过 SysApiMapper 的单条 XML 查询获得启用角色、启用菜单关联的 API，再使用原有 MapStruct 协作者转换为 DTO。沿用 user_uid；不依赖 system_user 表、不操作当前认证对象、不隐式提升 root 权限。

## 可复现验证

从 Git 仓库根执行，H2 测试依赖首次运行需联网下载，之后可使用 `-o`。

```powershell
mvn -o -pl fairychar-security/fairychar-security-boot-starter -am clean package '-DskipTests=false' '-Dflatten.skip=true' '-Dmaven.source.skip=true' '-Dtest=EffectiveApiPermissionsTest,InMemCodeVerifierTest,JsonAuthenticationFilterTest,SpringBoot4CompatibilityTest,JsonResponseCompatibilityTest' '-Dsurefire.failIfNoSpecifiedTests=false'
mvn -o compile '-DskipTests' '-Dflatten.skip=true' '-Dmaven.source.skip=true'
```

`EffectiveApiPermissionsTest` 使用 H2 2.4.240 的 MySQL 模式、实际 XML Mapper、实际 Service 和 MapStruct 实现，不用模拟 Mapper 替代 SQL。

| 场景 | 结果 |
| --- | --- |
| 多角色、多个菜单与重复关联指向相同 API，不重复返回；按 sort、id 排序 | 通过 |
| 同路径不同 HTTP 方法均保留；隐藏但启用的菜单仍授权 | 通过 |
| 无关联 UID 返回空列表，支持超过 Integer 范围的 Long UID | 通过 |
| 禁用角色和 enable=null 角色不授权 | 通过 |
| 禁用菜单和 enable=null 菜单不授权 | 通过 |
| 悬空角色、菜单和 API 关系不引入权限，用户间权限隔离 | 通过 |
| level=0 仅获得显式关联权限，不隐式全量授权 | 通过 |
| 同一 SqlSession 内再次查询反映已提交的撤权，无需手动清理一级缓存 | 通过 |
| 部分角色撤权不影响其他角色授予的相同权限 | 通过 |
| null UID 抛参数校验业务异常，不退化为全量查询 | 通过 |

测试类共 10 个用例。最初的 8 项测试先通过反射探测目标方法，未实现时取得 1 项失败、7 项错误，原因均为目标方法不存在；实现后改为接口对应方法的直接调用，首轮 8/8 通过，再补充两个场景。最终清理后打包时，本次 10 项与已有 35 项专项测试共 45 项通过，失败、错误、跳过均为 0。根 reactor 的 8 个项目编译通过。

## 导航与静态检查

- 导航已重建为 `snapshot-20261113T080210Z-e97fb091`；投影校验与独立声明遍历通过，286 个源码文件、2256 个声明，无缺失或多余；生成时验收 16/16。
- 已复查 freshness、incoming、outgoing 与 verify；导航不涵盖 Mapper XML、依赖注入与运行时分派，不能替代上述 SQL 测试。
- 风格巡检：无 Tab；core 历史超过 140 列告警仍为 14，无新增。
- 工作区与暂存区 `git diff --check` 通过；新增方案、测试文档与共享阶段记录的相对链接及尾部空白检查通过。
- IDE 定向构建仍因未重新加载的依赖模型报告 MyBatis-Plus 的 IService／ServiceImpl 缺失，不记为通过；上述 Maven 清理后构建通过。
- 本地原始日志保存在忽略目录 `codingRuntime/code-guide-work/boot4-validation/`，文件名为 `rbac-red.log`、`rbac-green.log`、`rbac-package.log`、`rbac-root-compile.log` 和 `rbac-navigation.log`。

## 限制与提交边界

H2 测试仅建立此次查询需要的列，未验证目标 MySQL 部署、完整 DDL、索引性能、多租户拦截器组合或并发授权变更。没有运行数据库认证、请求级越权与 Session 撤权的端到端验收。方法读取当前数据库授权，不代表已登录对象中的旧权限已刷新。

验证使用包含此前未提交 Boot 4 迁移的工作区。本次只提交 R2 方法、XML、H2 测试依赖、测试和独立方案／证据文档。前序迁移与已有暂存内容保持不变；正式导航按当前整个源码快照更新，因混合前序迁移不纳入此次独立提交。共享阶段入口保留本次进度更新，不混入前序未提交正文。

## 剩余项

- R1：宿主认证扩展入口，按用户要求不作为缺口。
- R2：本次聚合能力及上述专项测试已完成。
- R3：宿主将聚合结果装载到认证对象的桥接尚未完成。
- R4／R5：API 权限过滤器装配、方法通配符与混合权限类型边界尚未修复。
- R6／R7：账户管理安全边界、授权变更与在线会话刷新联动仍待明确和处理，不替代宿主认证职责。
- R8／R9：RBAC 装配入口和管理端接口的库／宿主职责范围待明确。
- R10：已补聚合 SQL 测试；目标数据库、请求鉴权、在线撤权等更广泛集成测试仍未完成。
- 非 RBAC 遗留：多租户插件组合、JSON 登录字段校验、解密异常分类、后置处理器契约及真实外部服务集成验证。
