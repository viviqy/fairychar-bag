# com.fairychar.bag.extension.concurrent.RepeatTaskExecutor

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RepeatTaskExecutor.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9484b628c8390536"></a>
## com.fairychar.bag.extension.concurrent.RepeatTaskExecutor

```java
@Slf4j
public final class RepeatTaskExecutor
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RepeatTaskExecutor.java:23`; evidence: `declaration-9484b628c8390536edd7b9286f8e201378d1403fff0d776c651bf60f473bb16c`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>
 任务编排循环执行工具
 <p>
 传入任务列表后,将会根据批次无限循环执行
 </p>

 @author chiyo
```


## Fields

<a id="symbol-046f4963fd558576"></a>
### cyclicBarrier

```java
private final CyclicBarrier cyclicBarrier
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RepeatTaskExecutor.java:25`; evidence: `declaration-046f4963fd558576ade25560bf01b7a3d211bbcaf27660224a5940344095a920`.
Visibility: `private` (explicit).
Type: `CyclicBarrier`.
No initializer recorded.

<a id="symbol-b7aefd02117f2254"></a>
### runnables

```java
private final List<Action> runnables
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RepeatTaskExecutor.java:26`; evidence: `declaration-b7aefd02117f2254684ef27d68353598e34133563e1c4fedfbd30cbbf47f6208`.
Visibility: `private` (explicit).
Type: `List<Action>`.
No initializer recorded.

<a id="symbol-41bd2f198728914c"></a>
### executorService

```java
private final ExecutorService executorService
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RepeatTaskExecutor.java:27`; evidence: `declaration-41bd2f198728914cf1e36de035223446261f0960c70e87dab88a20ebedee9ad9`.
Visibility: `private` (explicit).
Type: `ExecutorService`.
No initializer recorded.

<a id="symbol-b6ee9a319d9886ae"></a>
### executeTimes

```java
private final AtomicLong executeTimes
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RepeatTaskExecutor.java:28`; evidence: `declaration-b6ee9a319d9886ae289916ce6ec1961c2ec9f117f4376fa3a7e1683ebdf9b865`.
Visibility: `private` (explicit).
Type: `AtomicLong`.
No initializer recorded.

## Members

- [RepeatTaskExecutor](RepeatTaskExecutor.RepeatTaskExecutor.md#symbol-315b2078b4d584d3) — `constructor`, source line 30
- [createCycle](RepeatTaskExecutor.createCycle.md#symbol-37e69ad155f6ed5f) — `function`, source line 46
- [start](RepeatTaskExecutor.start--a896f3aee8840164.md#symbol-18531fa9c4d58e8d) — `function`, source line 54
- [start](RepeatTaskExecutor.start--7bc5909be8e0d78e.md#symbol-16cdf5fea61bb30a) — `function`, source line 67
- [getExecutedTimes](RepeatTaskExecutor.getExecutedTimes.md#symbol-d8f0085c8595f7b7) — `function`, source line 97
- [stop](RepeatTaskExecutor.stop.md#symbol-435ee8ed9d5ae106) — `function`, source line 105
