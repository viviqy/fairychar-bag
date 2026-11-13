# R2：用户有效 API 权限聚合

- 日期：2026-11-13；原始分支：`snapshot/1.4.3`。
- 用户确认：R1 的用户认证实现由宿主扩展，不列为未完成项。本次只实现 R2，不写入 SecurityContext、不新增 UserDetailsService 或 Controller。

## 契约

在现有 `ISysApiService` 提供 `listEffectiveByUserUid(Long userUid)`，返回 `List<SysApiDTO>`。参数是 `user_has_role.user_uid`，不是 `system_user.id`。null 参数抛出既有参数校验业务异常；没有授权返回空列表。

使用 `sys_api` 上的 EXISTS 关联子查询，沿 `user_has_role → system_role → role_has_menu → sys_menu → menu_has_api` 聚合，角色与菜单的 enable 必须明确为 true。重复角色、重复关联及多个菜单指向同一 API 不重复返回该 API 记录，按 API sort、id 排序。不同 HTTP 方法的 API 记录保留。API 表本身没有启用字段。

不查询 `system_user` 状态，以支持宿主账户体系直接使用统一 UID；账户认证状态由宿主负责。无效或不存在的角色、菜单、API 无法通过内连接取得授权。菜单 hidden 只表示显示属性，不用于撤权；不递归授予子菜单或继承父菜单权限；level=0 不隐式获得全部权限。调用方不得将外部任意 UID 当作当前认证用户，应从可信身份取得 UID。

沿用现有 SysApiMapper/XML 与 SysApiStructure 转换，不引入 N+1 查询。查询不使用 MyBatis 查询缓存，每次调用读取当前数据库授权；不承诺替调用方刷新已登录 Session 的权限，也不承诺跨事务隔离级别的即时可见性。

## 宿主调用

注入 `ISysApiService` 后，以宿主认证结果中的可信 UID 调用 `listEffectiveByUserUid(userUid)`。返回 DTO 的 `httpMethod`、`uri` 即该用户已分配的接口权限。宿主继续自行实现账户认证；将查询结果转换为认证对象中的权限属于 R3，不由本方法隐式执行。RBAC Service、Mapper、XML 和数据源的扫描装配仍沿用宿主接入方式。

去重单位是 `sys_api.id`，不是运行时路径模式合并；不同 API 记录不会被合并或扩展成更宽泛的授权。查询没有缓存授权结果，也不会因此自动清除调用方保存的权限快照。

## 验证计划与边界

用 H2 MySQL 模式执行真实 XML Mapper 查询，覆盖多角色去重、启用过滤、隐藏菜单、UID 隔离、断链、无授权、撤权及空参数；再回归既有 security 专项测试。H2 不代替目标 MySQL 和多租户插件组合验收。

R3 的认证对象装载、R4 过滤器装配、R5 匹配边界、R6 账户管理安全规则、R7 会话撤权联动、R8 RBAC 装配入口、R9 管理端接口范围、R10 更广泛数据库和越权测试仍独立保留，不与本次聚合完成混同。
