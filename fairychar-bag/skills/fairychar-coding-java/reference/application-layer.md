# 应用层 Controller 与 Service 规范

适用于类似 `code/src/main/java/com/fairychar/bag/controller`、`code/src/main/java/com/fairychar/bag/service`、`code/src/main/java/com/fairychar/bag/service/interfaces` 的应用模块。不要把本规范套到 `fairychar-bag/src` 可复用库代码中。

## Service 接口与实现

- 每个 `*Service` 实现类必须有匹配接口。
- 接口包固定为 `service.interfaces`，命名为 `I<Name>Service`。
- 实现类包固定为 `service`，命名为 `<Name>Service`。
- 实现类声明：`public class PermissionPolicyService extends ServiceImpl<Mapper, Entity> implements IPermissionPolicyService`。
- 显式 Bean 名称使用 lower camel case：`@Service("permissionPolicyService")`。
- Controller 和其他 Service 优先注入接口类型；不要在调用方依赖实现类专有方法。
- 公开 Service 方法必须先声明在接口中，实现在实现类中加 `@Override`。
- MyBatis-Plus 业务实现优先继承 `ServiceImpl<Mapper, Entity>`，接口继承 `IService<Entity>`。
- 需要自定义 SQL 时，通过 Mapper 接口方法调用 XML mapper；Mapper 规则见 `mybatis-plus-mapper.md`。

## Service 方法风格

- 常见 CRUD/query 方法名保持样例一致：`findOne`、`queryAll`、`pageAll`、`page`、`count`、`findById`、`save`、`updateById`、`saveBatch`、`findAll`。
- 领域动作使用明确动词，例如 `publish`。
- 查询、新增、更新请求体优先拆成明确的 `*Query`：查询用 `PermissionPolicyQuery`，新增用 `CreatePermissionPolicyQuery`，更新用 `UpdatePermissionPolicyQuery`。
- Service 接口和实现的方法签名必须使用对应场景的 Query 类型；例如 `save(CreatePermissionPolicyQuery query)`、`updateById(UpdatePermissionPolicyQuery query)`、`saveBatch(List<CreatePermissionPolicyQuery> batch)`。
- `Query`、Entity、DTO 转换通过 structure/converter 协作者完成，例如 `permissionPolicyStructure.queryToEntity(...)`。
- 新增、更新 Query 拆分后，structure/converter 方法名也要表达来源类型，例如 `queryToEntity(...)`、`updatePermissionPolicyQueryToEntity(...)`、`createPermissionPolicyQueriesToEntities(...)`。
- 不在 Controller 中做实体转换，不在 Service 方法里散落重复转换逻辑。
- 字段必填、格式等基础校验优先放在对应 Query 的 Bean Validation 注解中，并由 Controller 的 `@Validated` 触发。
- 依赖数据库或跨记录的业务校验放在 Service 私有方法中，例如 `validatePolicyCodeUnique`。
- 业务校验失败抛领域业务异常，并使用领域错误码；不要返回 `false` 或裸字符串错误。
- 查询分页结果转换时，保留分页元信息，再设置 DTO records。

## Controller 类风格

- 类注解使用：
  - `@RestController`
  - 类级 `@RequestMapping`
  - `@Tag(name = "...")`
  - `@ApiSupport(order = ...)`
- 每个公开 API 方法使用：
  - `@RequestLog`
  - HTTP mapping 注解：`@GetMapping`、`@PostMapping`、`@PutMapping`、`@DeleteMapping`
  - `@Operation(description = "...")`
  - `@ApiOperationSupport(order = ...)`
- API order 值保持稳定，并按 10 间隔递增，便于插入新接口。
- Controller 返回 `HttpResult`。
- 服务调用结果先放入局部变量 `result`，再 `return HttpResult.ok(result);`。
- 请求体对象使用 `@RequestBody`。
- 查询接口使用查询 Query，例如 `page(@RequestBody PermissionPolicyQuery query)`。
- 新增、更新等需要触发参数校验的请求体对象使用场景化 Query 和 `@RequestBody @Validated`，例如 `save(@RequestBody @Validated CreatePermissionPolicyQuery query)`、`update(@RequestBody @Validated UpdatePermissionPolicyQuery query)`。
- 路径 id 使用 `@PathVariable("id") Serializable id`。
- 方法名短且动作明确：`page`、`save`、`findById`、`update`、`delete`；领域动作暴露为 API 时使用明确动词，例如 `publish`。

## Controller 边界

- Controller 只负责接收请求、调用 Service、包装响应。
- Controller 可以通过 `@Validated` 触发 bean validation；不要在 Controller 中手写业务校验。
- 不在 Controller 中组装 QueryWrapper、Entity、DTO。
- 不在 Controller 中吞异常或手写错误响应；交给统一异常和 `HttpResult` 体系。

## 样例

- `code/src/main/java/com/fairychar/bag/controller/PermissionPolicyController.java`
- `code/src/main/java/com/fairychar/bag/service/PermissionPolicyService.java`
- `code/src/main/java/com/fairychar/bag/service/interfaces/IPermissionPolicyService.java`
