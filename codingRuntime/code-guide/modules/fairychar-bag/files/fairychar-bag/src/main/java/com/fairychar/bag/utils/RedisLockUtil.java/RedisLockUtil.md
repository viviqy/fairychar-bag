# com.fairychar.bag.utils.RedisLockUtil

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RedisLockUtil.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-bcdef019e661f466"></a>
## com.fairychar.bag.utils.RedisLockUtil

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RedisLockUtil
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/RedisLockUtil.java:17`; evidence: `declaration-bcdef019e661f466a6f339018f38e124555aa13d4c036785e91f5cf1e3654645`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
redis 锁 util

 @author chiyo <br>
 @since 1.0.2
```


## Fields

<a id="symbol-ec5de4e289d7b848"></a>
### EMPTY_ACTION

```java
private static final Action EMPTY_ACTION = () -> {
    }
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/RedisLockUtil.java:20`; evidence: `declaration-ec5de4e289d7b848e62108e85d80daf127c46659cbb601e5cf66e6a8c6b44aef`.
Visibility: `private` (explicit).
Type: `Action`.

## Members

- [lock](RedisLockUtil.lock--4bd98c4225846d9f.md#symbol-bc3149eed8ecee12) — `function`, source line 23
- [lock](RedisLockUtil.lock--d56196fbd8d86170.md#symbol-9edbba9d561c7809) — `function`, source line 27
- [lock](RedisLockUtil.lock--9bcd6c17310c89f3.md#symbol-792bd63c8c651735) — `function`, source line 31
- [lock](RedisLockUtil.lock--fbe378b26fc53f1b.md#symbol-71c606cdb543e734) — `function`, source line 35
- [lock](RedisLockUtil.lock--5f3091b59deb17b8.md#symbol-96c5fd9d5e265e63) — `function`, source line 40
- [lock](RedisLockUtil.lock--c18c4859569c8cc2.md#symbol-263ce570709a8f63) — `function`, source line 55
- [tryLock](RedisLockUtil.tryLock--762c7008d2708090.md#symbol-d542cfb59fcae7c6) — `function`, source line 71
- [tryLock](RedisLockUtil.tryLock--08147159a028a604.md#symbol-dd758e7fdd622a8c) — `function`, source line 75
- [tryLock](RedisLockUtil.tryLock--e8aaca82e820fe0e.md#symbol-723a4c1a125a4e96) — `function`, source line 79
- [tryLock](RedisLockUtil.tryLock--2b52f3a705da0995.md#symbol-0fe46ffc22bbe715) — `function`, source line 83
- [tryLock](RedisLockUtil.tryLock--0cc0cae99152b2d9.md#symbol-6c4070f6987e7289) — `function`, source line 87
- [tryLock](RedisLockUtil.tryLock--7ad6180403581e7d.md#symbol-d13aebb2a8abadd8) — `function`, source line 105
