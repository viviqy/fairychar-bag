# com.fairychar.bag.extension.concurrent.ActionSchedule

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ActionSchedule.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ca5b5cd4ebbc7515"></a>
## com.fairychar.bag.extension.concurrent.ActionSchedule

```java
@RequiredArgsConstructor
@Data
public final class ActionSchedule implements Comparable<ActionSchedule>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/ActionSchedule.java:17`; evidence: `declaration-ca5b5cd4ebbc75158ea277f3a8978fb66201fa0c3f401c6f5960f8e01ff6199e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
周期调度型任务,配合{@link com.fairychar.bag.template.ActionSelectorTemplate}使用

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-d80dfe7ed9592f5d"></a>
### taskName

```java
@NonNull
private String taskName
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/ActionSchedule.java:23`; evidence: `declaration-d80dfe7ed9592f5ddce1304dcd46b6b152ecb2615ed9176db3f8643060a09083`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
任务名称(默认当前线程名称)
```


<a id="symbol-4e6936a0aed936ed"></a>
### working

```java
private final AtomicBoolean working = new AtomicBoolean(false)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/ActionSchedule.java:29`; evidence: `declaration-4e6936a0aed936ed5aece10753d97e3af8da3a82fee48dde492bad88c952d64e`.
Visibility: `private` (explicit).
Type: `AtomicBoolean`.

Source docstring (unreviewed):
```text
任务执行状态，使用AtomicBoolean确保线程安全和原子操作
```


<a id="symbol-410e29ccd803058d"></a>
### period

```java
@NonNull
private long period
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/ActionSchedule.java:31`; evidence: `declaration-410e29ccd803058d01ee1bfdf0adb114cd67ca8dc82d84e6014242e7e68898cd`.
Visibility: `private` (explicit).
Type: `long`.
No initializer recorded.

<a id="symbol-b0113050f7204e7b"></a>
### lastExecuteTime

```java
private final AtomicLong lastExecuteTime = new AtomicLong(System.currentTimeMillis())
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/ActionSchedule.java:37`; evidence: `declaration-b0113050f7204e7b45375edac476d50a9de1d0b9fcf8350d5fe4062718d5abf0`.
Visibility: `private` (explicit).
Type: `AtomicLong`.

Source docstring (unreviewed):
```text
上次执行时间，使用AtomicLong确保线程安全
```


<a id="symbol-4d7ef79ae2e9cfda"></a>
### action

```java
@NonNull
private AbstractScheduleAction action
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/ActionSchedule.java:39`; evidence: `declaration-4d7ef79ae2e9cfda5046b4172c6e18b51e9715713a270909d83702b2ce746ed1`.
Visibility: `private` (explicit).
Type: `AbstractScheduleAction`.
No initializer recorded.

## Members

- [isWorking](ActionSchedule.isWorking.md#symbol-f6ffbaa665ef8662) — `function`, source line 46
- [getWorkingAtomic](ActionSchedule.getWorkingAtomic.md#symbol-2604b9ee25fd77b1) — `function`, source line 54
- [getLastExecuteTime](ActionSchedule.getLastExecuteTime.md#symbol-d405da5e4193056c) — `function`, source line 62
- [getLastExecuteTimeAtomic](ActionSchedule.getLastExecuteTimeAtomic.md#symbol-bbef3ad6c2e82bec) — `function`, source line 70
- [compareTo](ActionSchedule.compareTo.md#symbol-0035a825e4175c77) — `function`, source line 81
