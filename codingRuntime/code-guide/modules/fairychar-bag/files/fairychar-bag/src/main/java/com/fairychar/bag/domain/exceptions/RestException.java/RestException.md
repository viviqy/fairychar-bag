# com.fairychar.bag.domain.exceptions.RestException

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RestException.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5bcbf9a46b12c556"></a>
## com.fairychar.bag.domain.exceptions.RestException

```java
@Getter
public class RestException extends RuntimeException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/exceptions/RestException.java:11`; evidence: `declaration-5bcbf9a46b12c5567dd03e8cdc85f4634c7af5c0dd14418502a44ead8a43b276`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Rest异常类

 @author chiyo
 @since 0.0.1
```


### Reviewed responsibility
Exception carrier: four explicit constructors retain an IRestErrorCode and optionally an Object payload. Constructors without an explicit message pass errorCode.getMessage() to RuntimeException; message-taking overloads pass msg. The payload is assigned only by overloads accepting data.

Confidence: `high`; evidence: `f5dd16fe7c18ca5bd80def936ae67e096cdb77119a76bd02ed1590f577db14b9` in claims.jsonl.
Unknowns: Payload schema and downstream consumers were not traced; Lombok-generated accessors are not extracted; HTTP serialization and handler mapping are outside this reviewed claim

## Fields

<a id="symbol-e9c54b9482b12c1f"></a>
### errorCode

```java
private IRestErrorCode errorCode
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/exceptions/RestException.java:13`; evidence: `declaration-e9c54b9482b12c1fe7ba7aab85e55a27197f8dd9301f3be45c32daab5946c224`.
Visibility: `private` (explicit).
Type: `IRestErrorCode`.
No initializer recorded.

<a id="symbol-56b4b7f8e9cf0c0c"></a>
### data

```java
private Object data
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/exceptions/RestException.java:14`; evidence: `declaration-56b4b7f8e9cf0c0c674bfce401bc87e2d420afd0e933ab740dd49f1bafcf017d`.
Visibility: `private` (explicit).
Type: `Object`.
No initializer recorded.

## Members

- [RestException](RestException.RestException--eaf8ed085209767f.md#symbol-5fed61019888ac52) — `constructor`, source line 16
- [RestException](RestException.RestException--061c43ed44cbfa03.md#symbol-4e9665f5e47785cf) — `constructor`, source line 23
- [RestException](RestException.RestException--bb192d6320043a64.md#symbol-8d911a16a7e21de4) — `constructor`, source line 28
- [RestException](RestException.RestException--9e89afdf45329c75.md#symbol-57f8690bf9afeab8) — `constructor`, source line 33
