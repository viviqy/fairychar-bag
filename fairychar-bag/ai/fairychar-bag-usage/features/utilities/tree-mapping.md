# 树构造与对象映射

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## MappingObjectUtil

位置: `com.fairychar.bag.utils.MappingObjectUtil`

关联输出载体（完整构造器及生成访问器见 [AO API](../../api/pojo-ao.md)）：

| 类型 | 数据结构 |
| --- | --- |
| `MappingAO<K,V>` | `key`、`value`，简单键值对 |
| `MappingObjectAO<K,V>` | `key`、`count`、`values`，带数量的分组 |
| `MapObjectNode<T>` | `name`、`count`、`value`、`child`，树形分组节点 |
| `TreeNode<T>` | `current`、`child`，`current` 有 `@JsonUnwrapped`，业务 JSON 序列化时需注意字段名冲突 |

它们是可变数据载体，不提供环检测、排序、线程安全或自动持久化。`FieldContainer` 则是反射字段与所属对象的协作载体，见 [utils.base API](../../api/utils-base.md)，不宜作为对外业务响应。

#### 列表转 TreeNode

```java
List<TreeNode<Menu>> tree = MappingObjectUtil.listToTree(
        menus,
        "parentId",
        "id",
        0L
);
```

返回 `TreeNode<T>`:

- `current`: 当前对象。
- `child`: 子节点列表。

#### 列表转原对象树

```java
List<Menu> tree = MappingObjectUtil.listToTree(
        menus,
        "parentId",
        "id",
        "children",
        0L
);
```

要求对象有同名字段:

- `parentId`
- `id`
- `children`

且 `children` 类型能接收 `List<T>`。

#### Map 转展示对象

```java
List<MappingAO<String, Long>> items = MappingObjectUtil.mapping(countMap);
List<MappingObjectAO<String, User>> groups = MappingObjectUtil.mappingList(groupMap);
List<MapObjectNode<User>> nodes = MappingObjectUtil.mapToNode(nestedGroupMap);
```

用途:

- `mapping`: `Map<K,V>` -> `List<MappingAO<K,V>>`
- `mappingList`: `Map<K,List<V>>` -> 带 count 的列表。
- `mapToNode`: 支持嵌套 `Map` 或末级 `List` 的树节点包装。

## 输入、效果与失败契约

**前置与输入**：树构造使用当前类声明的 id/pid 字段，节点与 pid 非 null，id/pid 类型和值可比较；关系必须无环。带 childField 的重载要求该字段可写且能接收 List。不支持依据 getter 或父类字段自动推断结构。

**效果与返回**：`listToTree(source,pid,id,rootId)` 返回新的 `TreeNode` 包装列表，`current` 指向原节点；叶子的 child 未赋值，可为 null。带 childField 的重载直接修改原节点，把非空子项 List 写入指定字段；叶子原有 child 值不会自动清空。孤立节点不会自动成为根。

**其他映射**：`mapping(Map)` 新建键值载体列表；`mappingList(Map<K,List<V>>)` 新建含 size 的载体，但 value 仍是原 List。`mapToNode` 要求每个 value 是 List 或下一层 Map，名称来自 `String.valueOf(key)`；中间 count 是 Map 条目数，不是递归叶子总数。遍历顺序取决于输入 Map。

**失败**：缺字段或无法访问时反射异常可直接逃逸，即使签名没声明 throws；null pid、null 容器或不符合 Map/List 结构会失败。环会导致不终止或栈溢出，没有环检测或事务回滚；修改型重载失败前已写入的节点不恢复。

**副作用与资源**：同一对象树不并发修改；需隔离响应时先复制业务 DTO，不用于授权或安全深拷贝。

**输入 → 输出**：节点 `(id=1,pid=0),(id=2,pid=1)`、rootId=0 → 一棵 1 包含 2 的树；没有匹配根 → 空 List。输入根和子节点仍是相同对象引用。

## 类型与完整签名

- [`com.fairychar.bag.pojo.ao.MapObjectNode`](../../api/pojo-ao.md)
- [`com.fairychar.bag.pojo.ao.MappingAO`](../../api/pojo-ao.md)
- [`com.fairychar.bag.pojo.ao.MappingObjectAO`](../../api/pojo-ao.md)
- [`com.fairychar.bag.pojo.ao.TreeNode`](../../api/pojo-ao.md)
- [`com.fairychar.bag.utils.MappingObjectUtil`](../../api/utils--mappingobjectutil.md)
