# com.fairychar.bag.domain.netty.advice.InvokeEntity

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../InvokeEntity.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-fcc05764b783e295"></a>
## com.fairychar.bag.domain.netty.advice.InvokeEntity

```java
@AllArgsConstructor
@Getter
class InvokeEntity
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/InvokeEntity.java:12`; evidence: `declaration-fcc05764b783e2955928dcf09e5b2ced89ae5b0433a5a8f7f69cc4e0418f28e5`.
Owner: `<top-level>`; visibility: `package-private` (language default or unknown).

Source docstring (unreviewed):
```text
Method参数包装实体
 method.invoke(obj,args..)
 obj=bean method的执行类
 args=args method的执行参数
```


## Fields

<a id="symbol-e23b371f6b29b46c"></a>
### bean

```java
private final Object bean
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/InvokeEntity.java:15`; evidence: `declaration-e23b371f6b29b46c964b3f4f54b9c84544646f9038df0a6677d0601aba82949e`.
Visibility: `private` (explicit).
Type: `Object`.
No initializer recorded.

<a id="symbol-45d016dc15248a3c"></a>
### args

```java
private final Object[] args
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/InvokeEntity.java:16`; evidence: `declaration-45d016dc15248a3c39fc8d83b32ae71e0e8327ab40debe32163db017b8c4622f`.
Visibility: `private` (explicit).
Type: `Object[]`.
No initializer recorded.
