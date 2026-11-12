# MyBatis 租户查询开关

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 租户拦截器

#### SwitchableTenantLineInnerInterceptor

Mapper 参数中传入 `ITenantSwitcher`，动态决定该次查询是否使用租户插件。

```java
List<User> listUsers(@Param("query") UserQuery query, ITenantSwitcher tenantSwitcher);

userMapper.listUsers(query, new TenantSwitcher(false)); // 不使用租户
userMapper.listUsers(query, new TenantSwitcher(true));  // 使用租户
```

如果参数中没有 `ITenantSwitcher`，默认使用租户。

#### SkipableTenantLineInnerInterceptor

通过 `ITenantSkipper` 的线程上下文跳过租户处理。

```java
SimpleTenantSkipper skipper = new SimpleTenantSkipper();

try {
    skipper.setSkip(true);
    return userMapper.listAll();
} finally {
    skipper.cleanContext();
}
```

`SimpleTenantSkipper` 的默认 ThreadLocal 初始值为 true，代表跳过；cleanContext 后下次读取仍为 true。该默认组合不作为新项目默认隔离方案，且开关只覆盖查询；下面进一步说明 SQL、线程与清理边界。

## 租户开关

**前置与输入**：业务自己配置 MyBatis Plus 插件链和 TenantLineHandler；这些开关不是自动鉴权。`ITenantSwitcher` 控制的是 `use()`；`ITenantSkipper` 控制的是 `getSkip()`，布尔含义相反。

**效果与返回**：Switchable 查询只有在参数实际为 MapperMethod.ParamMap 且其中值是 ITenantSwitcher 时读取开关，true 使用租户、false 跳过；没有匹配开关时默认使用租户。普通 Map、单独传入 switcher 或嵌套 DTO 不能假设被识别；不要传多个相互冲突的开关，因为 Map 遍历没有参数先后保证。Skipable 查询在 getSkip=true 时跳过。

**安全限制**：默认 SimpleTenantSkipper 的当前线程初始值为 true；cleanContext 删除后下次读取重新得到 true。新项目不要将该默认组合当作“默认隔离”的方案。两种自定义开关只覆盖查询 beforeQuery；写 SQL 仍按父类和插件链处理，不能认为一个开关同时控制所有增删改查。

**副作用与资源**：查询 SQL 可被重写；线程变量不会自动传播到异步任务。若业务确实接入线程开关，必须有同线程 try/finally 清理和明确的安全默认值；并验证线程池复用、异常及嵌套调用。

**最小验证**：两租户下查不到彼此数据、显式跳过的授权范围、无开关默认值、查询及写入分别验证。未完成这些测试时不接入隔离核心路径，优先采用业务现有的默认隔离方案。

## 类型与完整签名

- [`com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper`](../../api/beans-mybatis-interceptor.md)
- [`com.fairychar.bag.beans.mybatis.interceptor.ITenantSwitcher`](../../api/beans-mybatis-interceptor.md)
- [`com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper`](../../api/beans-mybatis-interceptor.md)
- [`com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor`](../../api/beans-mybatis-interceptor.md)
- [`com.fairychar.bag.beans.mybatis.interceptor.SwitchableTenantLineInnerInterceptor`](../../api/beans-mybatis-interceptor.md)
- [`com.fairychar.bag.beans.mybatis.interceptor.TenantSwitcher`](../../api/beans-mybatis-interceptor.md)
