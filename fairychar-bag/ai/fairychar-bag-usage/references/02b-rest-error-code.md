# RestErrorCode Reference

> 返回二级入口: [02-web-rest-aop-and-lock.md](02-web-rest-aop-and-lock.md)。代码示例放在 `../scripts/02b-rest-error-code-examples.md`。

## RestErrorCode

位置: `com.fairychar.bag.domain.exceptions.RestErrorCode`

用途: MVC 统一错误码枚举。写业务代码前必须先查本页，优先复用已有枚举，避免重复定义相同语义的 code/message。

错误码区间:

| 区间 | 含义 |
| --- | --- |
| `10000-11000` | 参数、文件类 |
| `12000+` | 数据操作类 |
| `13000-14000` | 当前源码预留，未定义枚举 |
| `14000+` | 权限类 |
| `18000+` | 通用业务异常 |
| `19000+` | 微服务类 |
| `20000+` | 系统类 |

使用规则:

- 写业务代码前先查下表，优先复用已有 `RestErrorCode`。
- 只有语义确实不存在时才新增枚举。
- `RestException` 构造方法接收 `IRestErrorCode`，已有 `RestErrorCode` 和项目自定义错误码枚举都可以传入。
- 新增业务错误码时不要在业务代码中散落裸数字和裸字符串；如果必须定义项目级枚举，应实现 `IRestErrorCode`。
- 表中的 `code` 是 Java 源码中数字下划线去掉后的实际 int 值。
- `FILE_TOO_LARGE` 当前源码为 `1_00013`，实际 int 值是 `100013`，这不是文档笔误。

## 参数和文件类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `PARAM_INVALIDATE` | `10000` | 参数校验失败 | Hibernate Validator、`@Valid`、字段约束校验失败 |
| `CONTENT_TYPE_NOT_SUPPORT` | `10001` | 请求类型不支持 | `Content-Type` 不符合接口要求 |
| `PARAM_ERROR` | `10002` | 参数错误 | 参数存在但业务格式、组合关系或语义错误 |
| `FILE_FORMAT_NOT_SUPPORT` | `10012` | 文件类型不支持 | 上传文件扩展名、MIME 或内容类型不支持 |
| `FILE_TOO_LARGE` | `100013` | 文件超大 | 上传文件超过允许大小；注意源码实际值为 `100013` |
| `FILE_TOO_SMALL` | `10014` | 文件太小 | 上传文件低于允许大小 |
| `FILE_EMPTY` | `10015` | 文件为空 | 上传文件为空或无内容 |
| `FILE_NAME_ILLEGAL` | `10016` | 文件名不合法 | 文件名包含非法字符、路径穿越或不符合命名规则 |
| `FILE_UPLOAD_FAILED` | `10017` | 文件上传失败 | 文件传输、落盘、对象存储写入失败 |

## 数据操作类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `DATA_EXIST` | `12000` | 数据已存在 | 创建前唯一性检查发现已有数据 |
| `DATA_NOT_EXIST` | `12001` | 数据不存在 | 按 id、编码或条件查询不到数据 |
| `DUPLICATE_SAVE` | `12002` | 重复保存 | 幂等、重复提交、重复创建 |
| `DATA_DELETE_FAILED` | `12003` | 数据删除失败 | 删除数据库记录、缓存或资源失败 |
| `DATA_UPDATE_FAILED` | `12004` | 数据更新失败 | 更新数据库记录、状态流转或持久化失败 |
| `DATA_LOCKED` | `12005` | 数据被锁定 | 数据处于锁定状态，不能修改或删除 |
| `DATA_HIDDEN` | `12006` | 数据不可见 | 数据存在但当前上下文不可见 |
| `DATA_SYNC_ERROR` | `12007` | 数据同步错误 | 内外部系统或缓存同步异常 |
| `DATA_TRANSFER_ERROR` | `12008` | 数据传输错误 | 数据搬运、导入导出、跨服务传输失败 |
| `DATA_CONVERT_ERROR` | `12009` | 数据转换错误 | DTO/Entity/VO、类型或格式转换失败 |
| `DATA_LOAD_ERROR` | `12010` | 数据加载错误 | 数据初始化、批量加载或远端加载失败 |
| `DATA_HAS_RELATION` | `12011` | 数据被其他数据关联 | 删除或变更前发现存在关联数据 |

## 权限和认证类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `AUTHENTICATION_FAILED` | `14000` | 认证失败 | 登录认证、身份校验失败 |
| `ACCESS_DEFINED` | `14003` | 权限不足 | 已认证但无接口、菜单或资源权限；源码枚举名为 `ACCESS_DEFINED` |
| `USER_NOT_FOUND` | `14004` | 用户不存在 | 登录、授权、用户查询时找不到用户 |
| `PASSWORD_ERROR` | `14005` | 密码错误 | 密码登录失败 |
| `TOKEN_NOT_EXIST` | `14006` | token不存在 | 请求缺少 token |
| `TOKEN_INVALID` | `14007` | token不合法 | token 格式、签名或结构不合法 |
| `TOKEN_EXPIRED` | `14008` | token过期 | token 已过期 |
| `USER_FROZEN` | `14009` | 用户被冻结 | 用户状态冻结，禁止登录或操作 |
| `USER_NO_PERMISSION` | `14010` | 用户没有权限 | 用户缺少业务权限 |
| `ROLE_FROZEN` | `14011` | 角色被冻结 | 角色状态冻结 |
| `PERMISSION_FROZEN` | `14012` | 权限被冻结 | 权限项状态冻结 |

## 通用业务异常类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `OPERATION_FAILED` | `18000` | 操作失败 | 无更具体语义的通用操作失败 |
| `SIGN_ERROR` | `18001` | 签名错误 | 请求签名、回调签名、验签失败 |
| `THIRD_REQUEST_FAILED` | `18002` | 第三方请求失败 | 调第三方接口失败 |
| `THIRD_CALLBACK_FAILED` | `18003` | 第三方回调失败 | 处理第三方回调失败 |
| `AUDIT_FAILED` | `18004` | 审核失败 | 审批、审核、校验流程未通过 |
| `GENERATE_FAILED` | `18005` | 生成失败 | 生成编号、文件、验证码、报表或其他产物失败 |
| `RATE_LIMIT_ERROR` | `18006` | 频率达到上限 | 限流、频控、重试次数达到上限 |
| `LOCK_FAILED` | `18007` | 锁失败 | 获取业务锁、分布式锁或状态锁失败 |
| `SYNC_FAILED` | `18008` | 同步失败 | 同步动作失败但不需要使用更具体的数据同步错误 |

## 微服务类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `FALLBACK` | `19001` | fallback | Feign fallback、远端服务降级 |

## 系统类

| 枚举 | code | message | 复用场景 |
| --- | ---: | --- | --- |
| `UNKNOWN_ERROR` | `20000` | 未知异常 | 无法分类的未知异常 |
| `SYSTEM_ERROR` | `20001` | 系统错误 | 系统内部错误、配置错误、组件不可用 |

## IRestErrorCode

位置: `com.fairychar.bag.domain.exceptions.IRestErrorCode`

用途: 错误码抽象接口。项目确实需要独立错误码枚举时，应实现该接口，保持 `int getCode()` 和 `String getMessage()` 的稳定契约。

当前能力:

- `RestErrorCode` 已实现 `IRestErrorCode`。
- `RestException` 构造方法参数类型是 `IRestErrorCode`。
- 自定义 `IRestErrorCode` 枚举可以直接用于 `new RestException(customCode)`。
- `DefaultExceptionAdvice` 会从 `IRestErrorCode` 读取 `code` 和 `message`，再写入 `HttpResult`。

新增错误码前的判断:

| 判断项 | 推荐动作 |
| --- | --- |
| 语义能被上表覆盖 | 直接复用 `RestErrorCode` |
| 只是默认 message 不够具体 | 复用 `RestErrorCode`，通过 `RestException(errorCode, msg)` 覆盖文案 |
| 需要携带具体冲突字段、失败 id、上下文 | 复用 `RestErrorCode`，通过 `RestException(errorCode, msg, data)` 携带 data |
| 项目有成体系的业务错误码区间 | 新增实现 `IRestErrorCode` 的枚举，并通过 `RestException` 抛出 |

## 禁止用法

- 不要在 Service 中直接抛裸 `RuntimeException("数据不存在")`。
- 不要在 Controller 中手写 `HttpResult.fail(12001, "数据不存在")` 替代 `RestException(RestErrorCode.DATA_NOT_EXIST)`。
- 不要为已有语义重复新增 `USER_NOT_EXISTS`、`DATA_MISSING`、`LOCK_ERROR` 这类近义错误码。
- 不要只新增错误码枚举而不接入统一异常和响应路径。
