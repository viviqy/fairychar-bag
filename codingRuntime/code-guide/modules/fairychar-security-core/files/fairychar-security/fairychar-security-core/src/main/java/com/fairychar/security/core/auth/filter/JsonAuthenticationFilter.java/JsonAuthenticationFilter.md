# com.fairychar.security.core.auth.filter.JsonAuthenticationFilter

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../JsonAuthenticationFilter.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-80b00d0f9c89cf16"></a>
## com.fairychar.security.core.auth.filter.JsonAuthenticationFilter

```java
@AllArgsConstructor
@Slf4j
public class JsonAuthenticationFilter<T extends IJsonLoginRequest> extends UsernamePasswordAuthenticationFilter
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/JsonAuthenticationFilter.java:46`; evidence: `declaration-80b00d0f9c89cf16487012039a95798bab98ae9840b89e07e6fa49bf02ce1cda`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>Json登录过滤器</p>
 <p>使用方式</p>
 <pre>
     {@code
   @Bean
   JsonAuthenticationFilter jsonAuthenticationFilter() throws Exception {
      JsonAuthenticationFilter filter = new JsonAuthenticationFilter();
      filter.setAuthenticationManager(authenticationManagerBean());
      //filter.setAuthenticationSuccessHandler(loginSuccessHandler);
      return filter;
   }

   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
   }}
 </pre>
 <code>
 <
 </code>

 @author chiyo
 @since 1.0
```


### Reviewed responsibility
JSON authentication boundary: attemptAuthentication rejects non-POST requests, compares the content type against two JSON constants, deserializes the request stream into requestClazz, optionally decrypts username and password, sets authentication details and delegates to the configured authentication manager. AuthenticationException is rethrown; other exceptions inside the deserialization/authentication try block become BadCredentialsException. Content-type access occurs before that try block.

Confidence: `high`; evidence: `d87cb32ff4350cf6884be700980afa753aa0dea8bd6108d77f8f78ff4d4291fd` in claims.jsonl.
Unknowns: Filter-chain registration and effective request routes were not resolved; Authentication-manager implementation and decryptor behavior remain unverified; No dependency API compatibility or runtime authentication success is asserted

## Fields

<a id="symbol-1c3f022b72373cb2"></a>
### mapper

```java
private final ObjectMapper mapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/JsonAuthenticationFilter.java:50`; evidence: `declaration-1c3f022b72373cb20b4e5a833ff5307052ad2be7fd6094d2df6b48c59208169e`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-317054e9a1405952"></a>
### usernameDecryptor

```java
private final IUsernameDecrypt usernameDecryptor
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/JsonAuthenticationFilter.java:51`; evidence: `declaration-317054e9a14059526c3d6c3849ba1dc0ad72c34153b64968aec485954f72e476`.
Visibility: `private` (explicit).
Type: `IUsernameDecrypt`.
No initializer recorded.

<a id="symbol-784bb054a9a1bdd3"></a>
### passwordDecryptor

```java
private final IPasswordDecrypt passwordDecryptor
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/JsonAuthenticationFilter.java:52`; evidence: `declaration-784bb054a9a1bdd30738ce4ad64f4fd6fd490bb0cd5d92ad6915a3e3730030a0`.
Visibility: `private` (explicit).
Type: `IPasswordDecrypt`.
No initializer recorded.

<a id="symbol-d704dc580a1a60f8"></a>
### requestClazz

```java
private final Class<T> requestClazz
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/auth/filter/JsonAuthenticationFilter.java:53`; evidence: `declaration-d704dc580a1a60f833533b62c7fd623d800edcb3ffdf5c5b88a2679a3e769612`.
Visibility: `private` (explicit).
Type: `Class<T>`.
No initializer recorded.

## Members

- [attemptAuthentication](JsonAuthenticationFilter.attemptAuthentication.md#symbol-1b3fa4b4cd7990da) — `function`, source line 55
- [getDecryptPassword](JsonAuthenticationFilter.getDecryptPassword.md#symbol-bfd4648e85c6d862) — `function`, source line 81
- [getDecryptUsername](JsonAuthenticationFilter.getDecryptUsername.md#symbol-2b2675c4a72781e5) — `function`, source line 88
