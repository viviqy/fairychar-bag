# com.fairychar.bag.domain.abstracts.AbstractScheduleAction

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AbstractScheduleAction.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d367a69d95454d38"></a>
## com.fairychar.bag.domain.abstracts.AbstractScheduleAction

```java
public abstract class AbstractScheduleAction implements Action
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/abstracts/AbstractScheduleAction.java:15`; evidence: `declaration-d367a69d95454d38d9490b7827bf8e3f18271184aab3008156f324a7e32e77b2`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/1/26 16:09

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-53e1dc0ba09b29b8"></a>
### executeThreads

```java
private Set<Thread> executeThreads = new ConcurrentHashSet<>(1)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/abstracts/AbstractScheduleAction.java:16`; evidence: `declaration-53e1dc0ba09b29b88011e2f0301b272df3d97638e4a2f5853d1956604ab115db`.
Visibility: `private` (explicit).
Type: `Set<Thread>`.

## Members

- [doAction](AbstractScheduleAction.doAction.md#symbol-482a68471383072b) — `function`, source line 24
- [doAction0](AbstractScheduleAction.doAction0.md#symbol-c2fe89acabd53d96) — `function`, source line 30
- [interrupt](AbstractScheduleAction.interrupt.md#symbol-8de29418620126cf) — `function`, source line 45
- [interruptAll](AbstractScheduleAction.interruptAll.md#symbol-1a019330a3e91625) — `function`, source line 52
