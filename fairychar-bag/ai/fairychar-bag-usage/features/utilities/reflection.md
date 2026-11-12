# 反射与字段操作

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## ReflectUtil

位置: `com.fairychar.bag.utils.ReflectUtil`

适用于简单 Bean 映射、递归查找字段、树形父子递归查找、字段擦除/保留。它直接使用反射字段，不依赖 getter/setter。

#### Map 和 Bean 转换

```java
Map<String, Object> map = Map.of("id", 1L, "name", "Tom");
User user = ReflectUtil.mapToEntity(map, User.class);

Map<String, Object> userMap = ReflectUtil.entityToMap(user, false);

UserVO vo = ReflectUtil.copyProperties(user, UserVO.class, false);
ReflectUtil.copyProperties(user, existingVO, false);
```

参数语义:

- `mapToEntity(map, clazz, mustMatchAll, matchNull)`
  - `mustMatchAll=true`: map key 在目标类找不到同名字段时抛异常。
  - `matchNull=true`: null 值也写入目标字段。
- `entityToMap(source, matchNull)`
  - `matchNull=false`: 跳过 null 值。
- `copyProperties(source, target, matchNull)`
  - 只复制同名字段。
  - `matchNull=false`: null 值不复制。

#### 字段保留和擦除

```java
ReflectUtil.eraseValue(user, "password,salt");
ReflectUtil.eraseValue(user, String.class);
ReflectUtil.keepValue(user, "id,name");
```

注意:

- `eraseValue(o, "*")` 会擦除当前类所有声明字段。
- `keepValue` 不作为复杂多字段筛选的默认方案；业务优先显式映射到独立 DTO，并断言保留与清空结果。
- final 字段可能抛异常。

#### 递归搜索父子

内存列表:

```java
List<Menu> children = ReflectUtil.recursiveSearchChild(allMenus, "id", "parentId", 0L);
List<Menu> parents = ReflectUtil.recursiveSearchParent(allMenus, "parentId", "id", childId);
```

函数式查询，适合数据库批量查询:

```java
List<Menu> allChildren = ReflectUtil.recursiveSearchChild("id", 0L, parentIds -> {
    return menuMapper.selectByParentIds(parentIds);
});

List<Menu> allParents = ReflectUtil.recursiveSearchParent("parentId", List.of(10L, 11L), ids -> {
    return menuMapper.selectByIds(ids);
});
```

#### 注解字段搜索

```java
Map<Class<? extends Annotation>, List<FieldContainer>> result =
        ReflectUtil.recursiveSearchFieldValueByAnnotations(
                user,
                List.of(FuzzyValue.class)
        );
```

支持递归对象、`Collection`、`Map`，并通过 `identityHashCode` 防止循环引用重复解析。

返回结果按注解类型分组，每个 `FieldContainer` 保存一个匹配字段的信息：

| 属性 | 含义 |
| --- | --- |
| `targetObject` | 该字段所属的实际对象 |
| `field` | 对应的 `java.lang.reflect.Field` |
| `path` | 递归搜索生成的字段路径 |

`FieldContainer` 是可变的反射结果载体，不是字段值快照，也不会自行执行搜索或类型转换。它用于配合 `ReflectUtil` 处理字段，不宜作为对外业务响应。

补充入口与边界：

- `recursiveSearchFieldByAnnotations(Class, Collection)` 查类型结构上的注解字段；`recursiveSearchFieldValueByAnnotations(Object, Collection)` 查实际对象并返回字段容器，二者不可互换。
- `recursiveSearch(List source, List ref, String idField, String pidField, I idValue)` 将递归找到的子项追加到调用方传入的 `ref`，不是返回新列表；输入关系应无环，id/pid 字段与空值由调用方保证。
- `getClassFields(Class, getParent, getStatic, getFinal)` 按开关收集字段集合；集合不保证声明顺序，不应据此构造固定 JSON 顺序。
- 上述低层反射方法不是安全的深拷贝、对象授权或完整 Bean 映射框架。参数和返回类型查询 [完整签名](../../api/utils.md)，复杂转换优先使用业务显式映射。

#### Unsafe 方法

`setLong`、`setInt`、`compareAndSwapLong`、`compareAndSwapInteger` 会修改包装类型内部值，属于危险能力。普通业务代码不要使用，除非明确需要做底层实验且有测试覆盖。

`getUnsafe()` 也属于同一危险能力，不作为新项目推荐入口；是否可访问受实际 JDK 环境约束。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `ReflectUtil` 低层映射/字段写入/Unsafe | 可修改原对象并触发反射/类型异常，没有授权、深拷贝和原子回滚保证；未逐方法闭合的行为仅签名可查 | 复杂转换采用业务显式 DTO 映射；不使用 Unsafe 修改包装值，不用反射筛选承担权限控制 |

## 类型与完整签名

- [`com.fairychar.bag.utils.ReflectUtil`](../../api/utils--reflectutil.md)
- [`com.fairychar.bag.utils.base.FieldContainer`](../../api/utils-base.md)
