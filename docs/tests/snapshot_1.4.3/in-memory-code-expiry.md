# 内存验证码过期时间修复与验证

- 日期：2026-11-13。
- 原始 Git 分支：`snapshot/1.4.3`。
- 范围：`InMemImageCodeVerifier`、`InMemPhoneCodeVerifier` 的生成与过期校验，不修改 Redis 验证器及其他认证逻辑。

## 根因与修复

两个内存验证器生成 `SimpleImageCode` 时均将 `expireTime` 写为 null，校验时却直接调用该字段的 `isBefore`，导致有效验证码也可能触发空指针。

- 图片验证码生成时按现有 `expireSeconds` 设置过期时间，默认 300 秒。
- 短信验证码生成时设置五分钟有效期，与现有默认 Caffeine 缓存有效期一致；即使通过构造器传入无 TTL 的缓存，记录本身仍有有效期。
- 校验时将空过期时间和已到期时间统一视为过期，清除记录并抛出既有 `BadCredentialsException("validate code expired")`，不放行无有效期数据。
- 保持错误验证码不消耗有效记录、成功后删除验证码的原行为；本次不声明并发消费的原子性保证。
- 图片缓存原有五分钟 TTL 保持不变，故配置大于五分钟不会延长缓存生命周期；这一既有配置限制未在本次修改。

## 验证

新增 `InMemCodeVerifierTest`，图片和短信各运行七个场景，共 14 项：生成记录的有效期与校验、空有效期拒绝并清理、过期拒绝并清理、成功后不可重复使用、错误码不消耗有效记录、缓存记录不存在、请求缺少 key。

短信 SDK 使用动态代理返回本地响应，不访问短信服务；图片使用实际生成链路。测试读取内部缓存核对过期时间，不依赖 sleep。

从 Git 根目录执行：

```powershell
mvn -o -pl fairychar-security/fairychar-security-core -am test '-DskipTests=false' '-Dflatten.skip=true' '-Dmaven.source.skip=true' '-Dtest=InMemCodeVerifierTest' '-Dsurefire.failIfNoSpecifiedTests=false'
mvn -o -pl fairychar-security/fairychar-security-boot-starter -am clean package '-DskipTests=false' '-Dflatten.skip=true' '-Dmaven.source.skip=true' '-Dtest=InMemCodeVerifierTest,JsonAuthenticationFilterTest,SpringBoot4CompatibilityTest,JsonResponseCompatibilityTest' '-Dsurefire.failIfNoSpecifiedTests=false'
```

- 修复前：14 项中 6 项失败，包含两个验证器的空有效期触发空指针、生成记录没有有效期、过期记录未清理。
- 修复后：定向 reactor 清理、重新编译、打包通过；本次 14 项及既有 21 项测试共 35 项通过，失败、错误、跳过均为 0。
- 首次编写测试时曾误用短信响应的 builder 方法导致测试编译失败，已按实际 SDK 的 `create()` 修正；之后才取得上述修复前后的有效测试结果。
- 风格巡检：无 Tab，core 超过 140 列的历史告警仍为 14，没有增加；工作区和暂存区的差异空白检查通过。
- 正式导航已重建，发布快照 `snapshot-20261113T065552Z-675acaeb`，生成门禁中的导航验收为 16/16。
- 导航投影与声明清单复核通过，286 个源码文件、2253 个声明，无缺失或多余；freshness 为 current，已复查 incoming、outgoing 与 verify 候选信息，不据此推断运行时完整覆盖。
- IDE 对本次两个生产 Java 文件的定向编译通过，有现有 MapStruct 处理器选项告警；不等同于 IDE 全量构建通过。
- 本地日志在忽略目录 `codingRuntime/code-guide-work/boot4-validation/` 的 `captcha-red.log`、`captcha-green.log` 和 `captcha-navigation.log`。

## 提交边界与限制

本次验证基于包含之前 Boot 4 迁移的工作区。迁移、文档迁移和旧导航改动在任务开始时尚未提交，不作为本次验证码修复的一部分提交；短信验证器此前的 Jackson import 改动也单独保留在工作区。导航已按整个当前源码快照重新生成，但因其包含前序迁移，仍与前序导航改动一起留在工作区，未混入本次提交。

共享阶段入口保留在 [阶段记录](../../workStage/snapshot_1.4.3/stage-snapshot_1.4.3.md)，该入口之前已有未提交内容。本次未执行真实短信、Redis、数据库、生产部署和并发压力验证。

## 剩余项

1. API 权限过滤器挂载及实际权限拦截效果待修复／核实。
2. 多租户插件装配与组合行为待修复／核实。
3. JSON 登录请求字段校验待处理。
4. 账号、密码解密异常分类待处理。
5. 登录后置处理器异常时的响应与认证状态契约待明确。
6. JWT 等其他 TokenType 尚未实现，属于能力缺口。
7. 真实 Redis Header Token、会话持久化、退出、并发会话及跨节点集成待验证；数据库、短信集成和 IDE Maven 重新加载后的构建待验证。
