# 分片计算扩展

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## IShardingProcessor

`calculateHash(P)` 对 `hashCode()` 先转 long、取绝对值，再转 int。输入不能为 null；`Integer.MIN_VALUE` 的边界在转回 int 后仍可能为负，不能把返回值理解为“保证非负的分片下标”。业务路由建议在 `calculate` 内用 `Math.floorMod(key.hashCode(), shardCount)`，并明确 `shardCount > 0`。

`BaseCalculator` 内部多处使用 Java `assert` 检查入参，不能依赖它承担生产参数校验。protected 计算方法及其字段转换逻辑不属于本索引的 public 方法计数。

实现 `IShardingProcessor<R,P>.calculate(P)`；`IDataBaseShardingProcessor` / `ITableShardingProcessor` 仅区分职责，不自动注册数据库或表路由。`BaseCalculator` / `Operator` 不是现成 public 通用计算服务。

## 类型与完整签名

- [`com.fairychar.bag.extension.calculator.BaseCalculator`](../../api/extension-calculator.md)
- [`com.fairychar.bag.extension.calculator.Operator`](../../api/extension-calculator.md)
- [`com.fairychar.bag.function.IDataBaseShardingProcessor`](../../api/function.md)
- [`com.fairychar.bag.function.IShardingProcessor`](../../api/function.md)
- [`com.fairychar.bag.function.ITableShardingProcessor`](../../api/function.md)
