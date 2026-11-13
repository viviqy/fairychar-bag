# com.fairychar.bag.utils.SpelUtil

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SpelUtil.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-e1e9a8e1a81cd41f"></a>
## com.fairychar.bag.utils.SpelUtil

```java
public class SpelUtil
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/SpelUtil.java:24`; evidence: `declaration-e1e9a8e1a81cd41fb0832fcd05a9eafb19fdb323ed606aa7e1e779a0b803c4a4`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
spel util

 @author chiyo <br>
 @date
```


## Fields

<a id="symbol-8e5268d1f1a2574f"></a>
### PARAMETER_NAME_DISCOVERER

```java
private static final ParameterNameDiscoverer PARAMETER_NAME_DISCOVERER = new DefaultParameterNameDiscoverer()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/SpelUtil.java:25`; evidence: `declaration-8e5268d1f1a2574f304f17891be0060b7de6c51355974215343818551fa9d616`.
Visibility: `private` (explicit).
Type: `ParameterNameDiscoverer`.

<a id="symbol-bd3db2f7847b26c4"></a>
### SPEL_EXPRESSION_PARSER

```java
private static final SpelExpressionParser SPEL_EXPRESSION_PARSER = new SpelExpressionParser()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/SpelUtil.java:26`; evidence: `declaration-bd3db2f7847b26c46480f74cb6bc48254ead863ee06e18759d078281887d832f`.
Visibility: `private` (explicit).
Type: `SpelExpressionParser`.

<a id="symbol-0b3c68ca79b966c7"></a>
### EXPRESSION_CACHE

```java
private static final Map<String, Expression> EXPRESSION_CACHE = new ConcurrentHashMap<>(64)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/SpelUtil.java:27`; evidence: `declaration-0b3c68ca79b966c7b9233f79282005bfda93e34f638bf78c3e7f96dd174fd394`.
Visibility: `private` (explicit).
Type: `Map<String, Expression>`.

## Members

- [eval](SpelUtil.eval--44a062cf42bd50a6.md#symbol-d8781582f561e3af) — `function`, source line 38
- [eval](SpelUtil.eval--9daa344b13698b95.md#symbol-f782b0a11b0d893b) — `function`, source line 55
- [createEvaluationContext](SpelUtil.createEvaluationContext.md#symbol-e97d26ff622382a6) — `function`, source line 70
- [parseExpression](SpelUtil.parseExpression.md#symbol-d86a84ad172dee5b) — `function`, source line 83
