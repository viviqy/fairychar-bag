# com.fairychar.bag.extension.concurrent.RoundTaskExecutor

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RoundTaskExecutor.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-22b77475a75d7502"></a>
## com.fairychar.bag.extension.concurrent.RoundTaskExecutor

```java
@Slf4j
public final class RoundTaskExecutor
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RoundTaskExecutor.java:22`; evidence: `declaration-22b77475a75d7502f0e833e71fea6e2944eca84e04c0f50c0be4914ed7214623`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>任务批量执行器</p>
 多个任务链将会同一下标的任务统一一起执行,全部执行成功后才会又执行下一个下标的任务

 @author chiyo
```


## Fields

<a id="symbol-3dd160c7e59b694f"></a>
### phaser

```java
private final Phaser phaser
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RoundTaskExecutor.java:24`; evidence: `declaration-3dd160c7e59b694f48ed333608ad67024e2ca786b02f1ee47d135fcbd617e9d5`.
Visibility: `private` (explicit).
Type: `Phaser`.
No initializer recorded.

<a id="symbol-ff1e1ef227fbcb2a"></a>
### taskList

```java
private final List<List<Action>> taskList
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RoundTaskExecutor.java:25`; evidence: `declaration-ff1e1ef227fbcb2a779a80c22d797e968aeefda9fc9429867646c3823a7f608e`.
Visibility: `private` (explicit).
Type: `List<List<Action>>`.
No initializer recorded.

<a id="symbol-13cccc40ad3087b6"></a>
### executeRound

```java
@Getter
private final AtomicInteger executeRound
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RoundTaskExecutor.java:29`; evidence: `declaration-13cccc40ad3087b6311aba51c21d97998e11c628f13bda1f1b68f558afcafbfe`.
Visibility: `private` (explicit).
Type: `AtomicInteger`.
No initializer recorded.

Source docstring (unreviewed):
```text
总任务执行轮数
```


<a id="symbol-eacfdfae66dd2d7d"></a>
### executedTaskCount

```java
@Getter
private final AtomicInteger executedTaskCount
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RoundTaskExecutor.java:34`; evidence: `declaration-eacfdfae66dd2d7d5fb57242f68cde6fa1aedd17f992f1c164b7507f01240131`.
Visibility: `private` (explicit).
Type: `AtomicInteger`.
No initializer recorded.

Source docstring (unreviewed):
```text
已执行完成的任务数量
```


<a id="symbol-6cfd0ac54bb0c7c3"></a>
### executedRound

```java
@Getter
private final AtomicInteger executedRound
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RoundTaskExecutor.java:39`; evidence: `declaration-6cfd0ac54bb0c7c3c3e44457176c913bedd0998ae4c438f3d4411d1b859780cd`.
Visibility: `private` (explicit).
Type: `AtomicInteger`.
No initializer recorded.

Source docstring (unreviewed):
```text
目前执行到的任务轮数
```


<a id="symbol-cd199d12b155f7e0"></a>
### executorService

```java
private final ExecutorService executorService
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/RoundTaskExecutor.java:41`; evidence: `declaration-cd199d12b155f7e0456c8592bbb2daf28cc56ffb6a0904740a441d31081ee731`.
Visibility: `private` (explicit).
Type: `ExecutorService`.
No initializer recorded.

## Members

- [RoundTaskExecutor](RoundTaskExecutor.RoundTaskExecutor.md#symbol-0b64b481ec7c7fcd) — `constructor`, source line 43
- [boxedTaskList](RoundTaskExecutor.boxedTaskList--0decd436fa2d8bf4.md#symbol-49ca7e7c6171754a) — `function`, source line 53
- [boxedTaskList](RoundTaskExecutor.boxedTaskList--e5ff42667667b0ce.md#symbol-efaa4b1987721d88) — `function`, source line 57
- [start](RoundTaskExecutor.start--5330070a4c6625b4.md#symbol-4efe360e6c7eed14) — `function`, source line 69
- [start](RoundTaskExecutor.start--b5a805f0cc183758.md#symbol-9eadcd9e64cd641c) — `function`, source line 79
- [awaitTaskDone](RoundTaskExecutor.awaitTaskDone.md#symbol-aa22ff55c11607be) — `function`, source line 84
- [stop](RoundTaskExecutor.stop.md#symbol-fe9fc3d8b9de2942) — `function`, source line 89
