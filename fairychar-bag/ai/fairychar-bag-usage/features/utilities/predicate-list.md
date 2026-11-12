# 按等价规则替换列表元素

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## BiPredicateList

构造器 `BiPredicateList(Collection<? extends T>, BiPredicate<T,T>)` 直接保留初始集合内容；不会对初始集合做去重。只有重写的 `add(T)`、`addAll(Collection)` 使用匹配替换逻辑。

`add(index, item)`、`addAll(index, collection)` 等继承操作不保证相同规则；`set` 也是普通替换。它不是 Set，也不是线程安全容器。业务测试应断言匹配替换、不匹配追加以及初始集合保留行为。

`add(item)` 用 `BiPredicate.test(newItem, existing)` 找到第一个匹配元素并替换；没有匹配项时追加。不是 Set，不是线程安全容器。

## 类型与完整签名

- [`com.fairychar.bag.extension.collection.BiPredicateList`](../../api/extension-collection.md)
