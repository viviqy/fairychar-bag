# `com.fairychar.bag.pojo.ao`

[返回 API 索引](README.md)

[MapObjectNode](#pojo-ao-mapobjectnode) · [MappingAO](#pojo-ao-mappingao) · [MappingObjectAO](#pojo-ao-mappingobjectao) · [TreeNode](#pojo-ao-treenode)

<a id="pojo-ao-mapobjectnode"></a>

## `com.fairychar.bag.pojo.ao.MapObjectNode`

类型声明：

```java
public class com.fairychar.bag.pojo.ao.MapObjectNode<T>
```

使用说明：[features/utilities/tree-mapping.md](../features/utilities/tree-mapping.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.pojo.ao.MapObjectNode()
public com.fairychar.bag.pojo.ao.MapObjectNode(java.lang.String,long,java.util.List<T>,java.util.List<com.fairychar.bag.pojo.ao.MapObjectNode<T>>)
```

### 当前类型声明的 public 方法

```java
public boolean com.fairychar.bag.pojo.ao.MapObjectNode.equals(java.lang.Object)
public com.fairychar.bag.pojo.ao.MapObjectNode<T> com.fairychar.bag.pojo.ao.MapObjectNode.setChild(java.util.List<com.fairychar.bag.pojo.ao.MapObjectNode<T>>)
public com.fairychar.bag.pojo.ao.MapObjectNode<T> com.fairychar.bag.pojo.ao.MapObjectNode.setCount(long)
public com.fairychar.bag.pojo.ao.MapObjectNode<T> com.fairychar.bag.pojo.ao.MapObjectNode.setName(java.lang.String)
public com.fairychar.bag.pojo.ao.MapObjectNode<T> com.fairychar.bag.pojo.ao.MapObjectNode.setValue(java.util.List<T>)
public int com.fairychar.bag.pojo.ao.MapObjectNode.hashCode()
public java.lang.String com.fairychar.bag.pojo.ao.MapObjectNode.getName()
public java.lang.String com.fairychar.bag.pojo.ao.MapObjectNode.toString()
public java.util.List<T> com.fairychar.bag.pojo.ao.MapObjectNode.getValue()
public java.util.List<com.fairychar.bag.pojo.ao.MapObjectNode<T>> com.fairychar.bag.pojo.ao.MapObjectNode.getChild()
public long com.fairychar.bag.pojo.ao.MapObjectNode.getCount()
```

### public 字段 / 枚举常量

无。

<a id="pojo-ao-mappingao"></a>

## `com.fairychar.bag.pojo.ao.MappingAO`

类型声明：

```java
public class com.fairychar.bag.pojo.ao.MappingAO<K,V>
```

使用说明：[features/utilities/tree-mapping.md](../features/utilities/tree-mapping.md)。

父类：`java.lang.Object`。

接口：`java.io.Serializable`。

### public 构造器

```java
public com.fairychar.bag.pojo.ao.MappingAO()
public com.fairychar.bag.pojo.ao.MappingAO(K,V)
```

### 当前类型声明的 public 方法

```java
public K com.fairychar.bag.pojo.ao.MappingAO.getKey()
public V com.fairychar.bag.pojo.ao.MappingAO.getValue()
public boolean com.fairychar.bag.pojo.ao.MappingAO.equals(java.lang.Object)
public com.fairychar.bag.pojo.ao.MappingAO<K, V> com.fairychar.bag.pojo.ao.MappingAO.setKey(K)
public com.fairychar.bag.pojo.ao.MappingAO<K, V> com.fairychar.bag.pojo.ao.MappingAO.setValue(V)
public int com.fairychar.bag.pojo.ao.MappingAO.hashCode()
public java.lang.String com.fairychar.bag.pojo.ao.MappingAO.toString()
```

### public 字段 / 枚举常量

无。

<a id="pojo-ao-mappingobjectao"></a>

## `com.fairychar.bag.pojo.ao.MappingObjectAO`

类型声明：

```java
public class com.fairychar.bag.pojo.ao.MappingObjectAO<K,V>
```

使用说明：[features/utilities/tree-mapping.md](../features/utilities/tree-mapping.md)。

父类：`java.lang.Object`。

接口：`java.io.Serializable`。

### public 构造器

```java
public com.fairychar.bag.pojo.ao.MappingObjectAO()
public com.fairychar.bag.pojo.ao.MappingObjectAO(K,long,java.util.List<V>)
```

### 当前类型声明的 public 方法

```java
public K com.fairychar.bag.pojo.ao.MappingObjectAO.getKey()
public boolean com.fairychar.bag.pojo.ao.MappingObjectAO.equals(java.lang.Object)
public com.fairychar.bag.pojo.ao.MappingObjectAO<K, V> com.fairychar.bag.pojo.ao.MappingObjectAO.setCount(long)
public com.fairychar.bag.pojo.ao.MappingObjectAO<K, V> com.fairychar.bag.pojo.ao.MappingObjectAO.setKey(K)
public com.fairychar.bag.pojo.ao.MappingObjectAO<K, V> com.fairychar.bag.pojo.ao.MappingObjectAO.setValues(java.util.List<V>)
public int com.fairychar.bag.pojo.ao.MappingObjectAO.hashCode()
public java.lang.String com.fairychar.bag.pojo.ao.MappingObjectAO.toString()
public java.util.List<V> com.fairychar.bag.pojo.ao.MappingObjectAO.getValues()
public long com.fairychar.bag.pojo.ao.MappingObjectAO.getCount()
```

### public 字段 / 枚举常量

无。

<a id="pojo-ao-treenode"></a>

## `com.fairychar.bag.pojo.ao.TreeNode`

类型声明：

```java
public class com.fairychar.bag.pojo.ao.TreeNode<T>
```

使用说明：[features/utilities/tree-mapping.md](../features/utilities/tree-mapping.md)。

父类：`java.lang.Object`。

接口：`java.io.Serializable`。

### public 构造器

```java
public com.fairychar.bag.pojo.ao.TreeNode()
public com.fairychar.bag.pojo.ao.TreeNode(T,java.util.List<com.fairychar.bag.pojo.ao.TreeNode<T>>)
```

### 当前类型声明的 public 方法

```java
public T com.fairychar.bag.pojo.ao.TreeNode.getCurrent()
public boolean com.fairychar.bag.pojo.ao.TreeNode.equals(java.lang.Object)
public com.fairychar.bag.pojo.ao.TreeNode<T> com.fairychar.bag.pojo.ao.TreeNode.setChild(java.util.List<com.fairychar.bag.pojo.ao.TreeNode<T>>)
public com.fairychar.bag.pojo.ao.TreeNode<T> com.fairychar.bag.pojo.ao.TreeNode.setCurrent(T)
public int com.fairychar.bag.pojo.ao.TreeNode.hashCode()
public java.lang.String com.fairychar.bag.pojo.ao.TreeNode.toString()
public java.util.List<com.fairychar.bag.pojo.ao.TreeNode<T>> com.fairychar.bag.pojo.ao.TreeNode.getChild()
```

### public 字段 / 枚举常量

无。

