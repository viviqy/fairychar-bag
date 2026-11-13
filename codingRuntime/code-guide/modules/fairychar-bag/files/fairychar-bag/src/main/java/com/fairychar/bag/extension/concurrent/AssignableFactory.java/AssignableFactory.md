# com.fairychar.bag.extension.concurrent.AssignableFactory

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AssignableFactory.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-0413ab1eb7890a91"></a>
## com.fairychar.bag.extension.concurrent.AssignableFactory

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AssignableFactory
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/AssignableFactory.java:26`; evidence: `declaration-0413ab1eb7890a910cbd609907493fbaaf13f6d9dc17a42d91f689c811e3dbef`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>
 任务权重分配工具类
 </p>
 <p>
 分配工人数多少并没有加快任务执行速度,
 分配意义在于如一个资源访问能接收3个
 流请求,A任务会建立2个流,B任务会建立
 一个流,限制A任务分配2个连接,B任务分配
 1个连接,则AB任务可同时运行,而2个B任务
 会其他一个进入等待队列之后运行
 </p>

 @author chiyo
```


## Fields

<a id="symbol-c80ccabfb75a9279"></a>
### executor

```java
private ExecutorService executor
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/AssignableFactory.java:28`; evidence: `declaration-c80ccabfb75a92797d01ee2c36aba62a509520ce99ea089e734c18ec9ac60801`.
Visibility: `private` (explicit).
Type: `ExecutorService`.
No initializer recorded.

<a id="symbol-911fdc445bd03ba1"></a>
### semaphore

```java
private Semaphore semaphore
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/concurrent/AssignableFactory.java:29`; evidence: `declaration-911fdc445bd03ba16f4be3a2872829e29c2c18acac12c025ff0e205c0c69e514`.
Visibility: `private` (explicit).
Type: `Semaphore`.
No initializer recorded.

## Members

- [recruitWorkers](AssignableFactory.recruitWorkers--ad6e3d906e0cc01d.md#symbol-c5e1c0e5b7d74d7e) — `function`, source line 38
- [recruitWorkers](AssignableFactory.recruitWorkers--6c79b14fd2ca681f.md#symbol-bb03acac35e01bd6) — `function`, source line 51
- [doWork](AssignableFactory.doWork--56b5c3d7b2eef6f9.md#symbol-2ca0b00a3b1d63e9) — `function`, source line 64
- [doWork](AssignableFactory.doWork--6881082757c378a4.md#symbol-a55b354b4ddf501b) — `function`, source line 74
- [doWork](AssignableFactory.doWork--733285e6d2115461.md#symbol-887c1fe46a4f8eb5) — `function`, source line 85
- [doWork](AssignableFactory.doWork--16f761392dd26a2b.md#symbol-ed94050e7142cd90) — `function`, source line 108
- [doWorkFuture](AssignableFactory.doWorkFuture.md#symbol-5fbb3d3de4e2fc39) — `function`, source line 123
- [getAvailableWorkers](AssignableFactory.getAvailableWorkers.md#symbol-8588127a788a31db) — `function`, source line 144
