# com.fairychar.bag.utils.ReflectUtil

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ReflectUtil.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-48aef98147402949"></a>
## com.fairychar.bag.utils.ReflectUtil

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class ReflectUtil
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:24`; evidence: `declaration-48aef981474029499e763167c09a2b9d0a62d6d277505f473086e05a86548483`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
反射工具类

 @author chiyo
 @since 0.0.1-SNAPSHOT
```


## Fields

<a id="symbol-df4ecdb98c07d18d"></a>
### REGEX_ALL

```java
private static final String REGEX_ALL = "*"
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/ReflectUtil.java:28`; evidence: `declaration-df4ecdb98c07d18d399e14a26a50ef443468047f81d922f8d91aaff3dca2951e`.
Visibility: `private` (explicit).
Type: `String`.

## Members

- [recursiveSearchFieldValueByAnnotations](ReflectUtil.recursiveSearchFieldValueByAnnotations--7974fa31fd119fcc.md#symbol-9d21290c3ec39e78) — `function`, source line 37
- [recursiveSearchParent](ReflectUtil.recursiveSearchParent--8f9d944d5453050e.md#symbol-69cf23372d6d4e53) — `function`, source line 55
- [recursiveSearchChild](ReflectUtil.recursiveSearchChild--3cf70dfb0b3dbc4d.md#symbol-3619067e19d2763d) — `function`, source line 72
- [recursiveSearchParent](ReflectUtil.recursiveSearchParent--8904e717da7fa409.md#symbol-ff36729b6eaf6e25) — `function`, source line 88
- [recursiveSearchParent](ReflectUtil.recursiveSearchParent--30d34cdb24b68122.md#symbol-5aa1397c492a690c) — `function`, source line 103
- [recursiveSearchChild](ReflectUtil.recursiveSearchChild--ca452ea386c882e3.md#symbol-1bf16700b8f80130) — `function`, source line 135
- [recursiveSearchChild](ReflectUtil.recursiveSearchChild--06c5c324441bd880.md#symbol-f8bcc455eaa0e67d) — `function`, source line 149
- [recursiveSearchFieldByAnnotations](ReflectUtil.recursiveSearchFieldByAnnotations--5643671d1f603504.md#symbol-d2332a6b2fc5a89f) — `function`, source line 159
- [recursiveSearch](ReflectUtil.recursiveSearch.md#symbol-469a3e950a056c55) — `function`, source line 180
- [keepValue](ReflectUtil.keepValue.md#symbol-d28af1e672bc8f02) — `function`, source line 212
- [eraseValue](ReflectUtil.eraseValue--59d78e6aa9f00d2f.md#symbol-7c3f2c0b7f86fe8d) — `function`, source line 232
- [eraseValue](ReflectUtil.eraseValue--f20ae8831f7b02ce.md#symbol-645423b2ca62093a) — `function`, source line 252
- [setLong](ReflectUtil.setLong.md#symbol-8bc4ffc038479b2a) — `function`, source line 290
- [setInt](ReflectUtil.setInt.md#symbol-43862ae4e8987d3e) — `function`, source line 305
- [compareAndSwapLong](ReflectUtil.compareAndSwapLong.md#symbol-348289234fa74b7d) — `function`, source line 321
- [compareAndSwapInteger](ReflectUtil.compareAndSwapInteger.md#symbol-bd32f0fd0ba85f7f) — `function`, source line 343
- [mapToEntity](ReflectUtil.mapToEntity--a20939c388eb55f9.md#symbol-3c2bb4d7e6dc1ebb) — `function`, source line 359
- [mapToEntity](ReflectUtil.mapToEntity--9db0bd428de9be09.md#symbol-a214fb096c1e6a44) — `function`, source line 363
- [entityToMap](ReflectUtil.entityToMap--f62413adb83b2a80.md#symbol-5123cf33bb3eefe4) — `function`, source line 387
- [entityToMap](ReflectUtil.entityToMap--3dc738fc491122c1.md#symbol-143764ceff1d94b7) — `function`, source line 391
- [getUnsafe](ReflectUtil.getUnsafe.md#symbol-ead55e1de51ed25c) — `function`, source line 409
- [getClassFields](ReflectUtil.getClassFields--aea899a9a4bedd51.md#symbol-4179a1bd282bb1be) — `function`, source line 429
- [copyProperties](ReflectUtil.copyProperties--aa4f851d362a2a3f.md#symbol-554fbc3198a9dd17) — `function`, source line 451
- [copyProperties](ReflectUtil.copyProperties--ac05a8b005deed74.md#symbol-2df9f1133652cff5) — `function`, source line 476
- [recursiveSearchFieldValueByAnnotations](ReflectUtil.recursiveSearchFieldValueByAnnotations--0be6891b73ed9d62.md#symbol-614a673da2b2e9f5) — `function`, source line 502
- [isNotJavaClass](ReflectUtil.isNotJavaClass.md#symbol-c991b31277576ac3) — `function`, source line 548
- [isSimpleField](ReflectUtil.isSimpleField.md#symbol-0615603e28f84cb6) — `function`, source line 558
- [searchIfInstanceOfCollection](ReflectUtil.searchIfInstanceOfCollection.md#symbol-a5732a7f50699e38) — `function`, source line 569
- [recursiveSearchFieldByAnnotations](ReflectUtil.recursiveSearchFieldByAnnotations--0a2fe2245c0b70c4.md#symbol-dda78c37d5a6af8e) — `function`, source line 674
- [recursiveSearchUntilEmpty](ReflectUtil.recursiveSearchUntilEmpty.md#symbol-7cd8be49c7850498) — `function`, source line 712
- [getClassFields](ReflectUtil.getClassFields--1c1fadb84d76845e.md#symbol-17e35989973fc21c) — `function`, source line 735
- [accessFields](ReflectUtil.accessFields.md#symbol-4598b16358b928b8) — `function`, source line 750
