# com.fairychar.bag.properties.AopProperties.Lock

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AopProperties.java.md)

[Lexical owner](AopProperties.md#symbol-fced3ef65f922750)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-176d2a5e5ed4d076"></a>
## com.fairychar.bag.properties.AopProperties.Lock

```java
@Getter
    @Setter
    public static class Lock
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/AopProperties.java:31`; evidence: `declaration-176d2a5e5ed4d0767292fc2b99bf5b850a909a5eeb8cd8996921a162078cefe8`.
Owner: `com.fairychar.bag.properties.AopProperties`; visibility: `public` (explicit).

## Fields

<a id="symbol-900e5ef486be686c"></a>
### enable

```java
private boolean enable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/AopProperties.java:37`; evidence: `declaration-900e5ef486be686c656319b3f8b58b188130cc44bb37a22b1fb88d049f7b72c3`.
Visibility: `private` (explicit).
Type: `boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
使用启用lock切面
```


<a id="symbol-a8e32bd3f4c391a3"></a>
### globalTimeout

```java
private int globalTimeout = 1
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/AopProperties.java:41`; evidence: `declaration-a8e32bd3f4c391a3a7548da8224bf98a729857f3167c38266a40aefe69d25c1d`.
Visibility: `private` (explicit).
Type: `int`.

Source docstring (unreviewed):
```text
全局超时时间,默认1
```


<a id="symbol-8c9625d007cda044"></a>
### timeUnit

```java
private TimeUnit timeUnit = TimeUnit.SECONDS
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/AopProperties.java:46`; evidence: `declaration-8c9625d007cda044a83cb056070a69220f228b2737885fcca803c0ba850125a1`.
Visibility: `private` (explicit).
Type: `TimeUnit`.

Source docstring (unreviewed):
```text
全局超时时间单位设置
```


<a id="symbol-2ed62ac77f934937"></a>
### defaultLock

```java
private MethodLock.Type defaultLock = MethodLock.Type.LOCAL
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/AopProperties.java:50`; evidence: `declaration-2ed62ac77f934937980cc1f09c6ca7f7407fb7bdb5c70f7deba4321ffef82a4f`.
Visibility: `private` (explicit).
Type: `MethodLock.Type`.

Source docstring (unreviewed):
```text
全局锁类型,默认使用本地锁,不能配置为DEFAULT
```
