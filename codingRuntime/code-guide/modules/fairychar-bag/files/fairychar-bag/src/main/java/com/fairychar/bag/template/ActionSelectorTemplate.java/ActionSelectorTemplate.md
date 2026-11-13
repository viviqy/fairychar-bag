# com.fairychar.bag.template.ActionSelectorTemplate

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ActionSelectorTemplate.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-64b3f560953c4115"></a>
## com.fairychar.bag.template.ActionSelectorTemplate

```java
@NoArgsConstructor
@Slf4j
public class ActionSelectorTemplate
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/template/ActionSelectorTemplate.java:22`; evidence: `declaration-64b3f560953c4115d49ce364e2927af8b1a24f34a9e981f7f9949af052f4731e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/1/26 10:32

 @author chiyo
 @since 1.0
```


### Reviewed responsibility
Scheduling hub: start submits a polling loop to boss; due entries acquire their working flag with compareAndSet before worker submission, update last-execution time, and clear the working flag in the worker finally block. put overloads validate positive periods, non-null actions and duplicate task names; remove can interrupt actions. Shutdown methods request executor shutdown and change runState, without awaiting termination.

Confidence: `high`; evidence: `d0867fa3b6df20e56083c6bbb7a06ebcd16104716772f2bbc14a7b6585798c1f` in claims.jsonl.
Unknowns: Lambda execution is not represented as a complete call graph; Task interruption and executor termination behavior were not runtime-tested; No thread-safety or shutdown-completion guarantee is asserted

## Fields

<a id="symbol-f6589cb40c1be0c2"></a>
### selector

```java
private Map<String, ActionSchedule> selector = new ConcurrentHashMap<>(32)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/template/ActionSelectorTemplate.java:27`; evidence: `declaration-f6589cb40c1be0c233b9f67f05ff69620ef73107718950f4d0d7c75685418a77`.
Visibility: `private` (explicit).
Type: `Map<String, ActionSchedule>`.

<a id="symbol-15dc9edd1c8f2463"></a>
### boss

```java
private ExecutorService boss = Executors.newSingleThreadExecutor()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/template/ActionSelectorTemplate.java:28`; evidence: `declaration-15dc9edd1c8f246333b457a12ac5410d8d990b15f14e37dbf1b7158455afd616`.
Visibility: `private` (explicit).
Type: `ExecutorService`.

<a id="symbol-3611199784d6003f"></a>
### timePause

```java
@Setter
private long timePause = 100
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/template/ActionSelectorTemplate.java:29`; evidence: `declaration-3611199784d6003f65150a4caad3adfd811b31d4cde7a33e9f356aac7b1cbbf6`.
Visibility: `private` (explicit).
Type: `long`.

<a id="symbol-cb7c65757d56de91"></a>
### worker

```java
private ExecutorService worker = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/template/ActionSelectorTemplate.java:32`; evidence: `declaration-cb7c65757d56de915e22f308d6289322ffc658d959322f6a42a72614054e3296`.
Visibility: `private` (explicit).
Type: `ExecutorService`.

<a id="symbol-8eb6b7ea7f44c5c9"></a>
### runState

```java
private volatile RunState runState = RunState.UN_INITIALIZE
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/template/ActionSelectorTemplate.java:33`; evidence: `declaration-8eb6b7ea7f44c5c977b558ece658628f701c0e00247d0b450c4d1db7e5e4f3d5`.
Visibility: `private` (explicit).
Type: `RunState`.

## Members

- [ActionSelectorTemplate](ActionSelectorTemplate.ActionSelectorTemplate.md#symbol-63a30b75e2068a75) — `constructor`, source line 36
- [start](ActionSelectorTemplate.start.md#symbol-4e63ee86da342736) — `function`, source line 41
- [shutdownGracefully](ActionSelectorTemplate.shutdownGracefully.md#symbol-5df16b56d09354a4) — `function`, source line 82
- [shutdownNow](ActionSelectorTemplate.shutdownNow.md#symbol-78b7b985a604f0cf) — `function`, source line 95
- [remove](ActionSelectorTemplate.remove--eaff93519eff0576.md#symbol-aff89e2e3380c49e) — `function`, source line 105
- [remove](ActionSelectorTemplate.remove--f120d91efd9a3662.md#symbol-71c0ef8a314c0fdb) — `function`, source line 109
- [put](ActionSelectorTemplate.put--a602656b550f1ce3.md#symbol-3d4a4946b0bad5de) — `function`, source line 120
- [checkState](ActionSelectorTemplate.checkState.md#symbol-e6cea0965718b7f7) — `function`, source line 127
- [put](ActionSelectorTemplate.put--1f195a4824ea6565.md#symbol-d913b60fee56bb79) — `function`, source line 134
- [put](ActionSelectorTemplate.put--3aeb7a926c842b25.md#symbol-4c6d8a95117fca59) — `function`, source line 145
- [checkArgs](ActionSelectorTemplate.checkArgs.md#symbol-b2b56cbb68a7c927) — `function`, source line 150
