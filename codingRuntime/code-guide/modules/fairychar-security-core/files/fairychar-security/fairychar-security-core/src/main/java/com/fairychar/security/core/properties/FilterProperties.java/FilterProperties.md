# com.fairychar.security.core.properties.FilterProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FilterProperties.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-1a56d439aa0354fa"></a>
## com.fairychar.security.core.properties.FilterProperties

```java
@Data
public class FilterProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:15`; evidence: `declaration-1a56d439aa0354fa82efb6c2a786eff855de5bf8bf550be4537dc9f3f0457755`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
拦截器配置

 @author chiyo <br>
```


## Fields

<a id="symbol-25ebc9005cc8481b"></a>
### apiPermission

```java
private ApiPermissionFilterProperties apiPermission = new ApiPermissionFilterProperties()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:20`; evidence: `declaration-25ebc9005cc8481b8e247e57a8695902240b48565eb924ac05634efb9ccac620`.
Visibility: `private` (explicit).
Type: `ApiPermissionFilterProperties`.

Source docstring (unreviewed):
```text
菜单拦截器
```


<a id="symbol-16c4480898b704d3"></a>
### verifyCode

```java
private VerifyCodeFilterProperties verifyCode = new VerifyCodeFilterProperties()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:24`; evidence: `declaration-16c4480898b704d31fa657c33297939ec2fb620b54ed789fe26128b0724b7b45`.
Visibility: `private` (explicit).
Type: `VerifyCodeFilterProperties`.

Source docstring (unreviewed):
```text
验证码拦截器
```


<a id="symbol-cefc270fc2b27bd0"></a>
### login

```java
private JsonLoginFilterProperties login = new JsonLoginFilterProperties()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:28`; evidence: `declaration-cefc270fc2b27bd066f4058ac7bfab9a50ea938a2fdf233b055dd2b5fd2731c0`.
Visibility: `private` (explicit).
Type: `JsonLoginFilterProperties`.

Source docstring (unreviewed):
```text
登录参数体配置
```


## Members

- [JsonLoginFilterProperties](FilterProperties.JsonLoginFilterProperties.md#symbol-7228bc7c14871ff5) — `class`, source line 30
- [VerifyCodeFilterProperties](FilterProperties.VerifyCodeFilterProperties.md#symbol-2e0e2dcee5e4a764) — `class`, source line 35
- [ApiPermissionFilterProperties](FilterProperties.ApiPermissionFilterProperties.md#symbol-0b67ce9a5c750b52) — `class`, source line 46
