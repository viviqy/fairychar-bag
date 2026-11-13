# com.fairychar.security.core.utils.ImageVerifyCodeUtil

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ImageVerifyCodeUtil.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d88535ce99f09a78"></a>
## com.fairychar.security.core.utils.ImageVerifyCodeUtil

```java
public class ImageVerifyCodeUtil
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/utils/ImageVerifyCodeUtil.java:14`; evidence: `declaration-d88535ce99f09a78b2d31f3da678a88c5e2eb739cdf62f1a18a7339e59badbf9`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
@author chiyo
```


## Fields

<a id="symbol-e535a1eecb7ed2d6"></a>
### MAP_TABLE

```java
private static final char[] MAP_TABLE = new char[]{
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', '0', '1',
            '2', '3', '4', '5', '6', '7',
            '8', '9'}
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/utils/ImageVerifyCodeUtil.java:15`; evidence: `declaration-e535a1eecb7ed2d63d1a0d2a7a439bcf590164598ebc184f0b430e541d967ae8`.
Visibility: `private` (explicit).
Type: `char[]`.

<a id="symbol-9d9ac6649fbcc787"></a>
### RANDOM

```java
private static final Random RANDOM = RandomUtil.getRandom()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/utils/ImageVerifyCodeUtil.java:20`; evidence: `declaration-9d9ac6649fbcc7872fe80668ae284235a31ff1d05d1606eaaeb30aa7532e83e4`.
Visibility: `private` (explicit).
Type: `Random`.

## Members

- [genImageCode](ImageVerifyCodeUtil.genImageCode.md#symbol-e1e162cedcba517d) — `function`, source line 22
- [getRandColor](ImageVerifyCodeUtil.getRandColor.md#symbol-d225a7810253027b) — `function`, source line 67
