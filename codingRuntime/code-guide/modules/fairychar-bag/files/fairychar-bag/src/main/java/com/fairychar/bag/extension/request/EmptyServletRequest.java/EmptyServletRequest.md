# com.fairychar.bag.extension.request.EmptyServletRequest

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../EmptyServletRequest.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-18d42b0741c36893"></a>
## com.fairychar.bag.extension.request.EmptyServletRequest

```java
@NoArgsConstructor
public class EmptyServletRequest implements HttpServletRequest
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/request/EmptyServletRequest.java:19`; evidence: `declaration-18d42b0741c36893729c2715fb9937343b065396841fffac596f662f8c7cb104`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
mock http空请求

 @author chiyo <br>
 @since 1.3.2
```


## Members

- [getAuthType](EmptyServletRequest.getAuthType.md#symbol-87d41c4c93e28e96) — `function`, source line 21
- [getCookies](EmptyServletRequest.getCookies.md#symbol-c5aafa04a5edfbb6) — `function`, source line 26
- [getDateHeader](EmptyServletRequest.getDateHeader.md#symbol-75364897701bb96f) — `function`, source line 31
- [getHeader](EmptyServletRequest.getHeader.md#symbol-0cddd362ba3770bd) — `function`, source line 36
- [getHeaders](EmptyServletRequest.getHeaders.md#symbol-eb9b97bebc72c7ea) — `function`, source line 41
- [getHeaderNames](EmptyServletRequest.getHeaderNames.md#symbol-bceeefb689974d48) — `function`, source line 46
- [getIntHeader](EmptyServletRequest.getIntHeader.md#symbol-a41d1b1d0d3242be) — `function`, source line 51
- [getMethod](EmptyServletRequest.getMethod.md#symbol-e5d2c9e7507d1e6f) — `function`, source line 56
- [getPathInfo](EmptyServletRequest.getPathInfo.md#symbol-db7a080d2ddcceef) — `function`, source line 61
- [getPathTranslated](EmptyServletRequest.getPathTranslated.md#symbol-67520713388c8f3e) — `function`, source line 66
- [getContextPath](EmptyServletRequest.getContextPath.md#symbol-90b6a4178f1f84fc) — `function`, source line 71
- [getQueryString](EmptyServletRequest.getQueryString.md#symbol-16cf04ea7c4336de) — `function`, source line 76
- [getRemoteUser](EmptyServletRequest.getRemoteUser.md#symbol-1a4a56cd517f16e7) — `function`, source line 81
- [isUserInRole](EmptyServletRequest.isUserInRole.md#symbol-76d830046b35225f) — `function`, source line 86
- [getUserPrincipal](EmptyServletRequest.getUserPrincipal.md#symbol-dc69117016da98da) — `function`, source line 91
- [getRequestedSessionId](EmptyServletRequest.getRequestedSessionId.md#symbol-f8fedf6a9df8b507) — `function`, source line 96
- [getRequestURI](EmptyServletRequest.getRequestURI.md#symbol-6930ed09be35e0d0) — `function`, source line 101
- [getRequestURL](EmptyServletRequest.getRequestURL.md#symbol-8fdf5d0cb1269bee) — `function`, source line 106
- [getServletPath](EmptyServletRequest.getServletPath.md#symbol-f13dbb1f65b5da5e) — `function`, source line 111
- [getSession](EmptyServletRequest.getSession--5e7044031f93f3d3.md#symbol-c7a61ca0ea5055eb) — `function`, source line 116
- [getSession](EmptyServletRequest.getSession--66c903f0ef317485.md#symbol-47a00cdefd1a145e) — `function`, source line 121
- [changeSessionId](EmptyServletRequest.changeSessionId.md#symbol-8df9c12b468e4d41) — `function`, source line 126
- [isRequestedSessionIdValid](EmptyServletRequest.isRequestedSessionIdValid.md#symbol-4986df89294b3e39) — `function`, source line 131
- [isRequestedSessionIdFromCookie](EmptyServletRequest.isRequestedSessionIdFromCookie.md#symbol-2b3776d9831a2c3c) — `function`, source line 136
- [isRequestedSessionIdFromURL](EmptyServletRequest.isRequestedSessionIdFromURL.md#symbol-cb272b5ae68d6508) — `function`, source line 141
- [authenticate](EmptyServletRequest.authenticate.md#symbol-e21ecc989a33106e) — `function`, source line 146
- [login](EmptyServletRequest.login.md#symbol-02e5f4e975b3a68e) — `function`, source line 151
- [logout](EmptyServletRequest.logout.md#symbol-90d6e921ba995153) — `function`, source line 156
- [getParts](EmptyServletRequest.getParts.md#symbol-6ca823814d18efd7) — `function`, source line 161
- [getPart](EmptyServletRequest.getPart.md#symbol-88749990c82a8719) — `function`, source line 166
- [upgrade](EmptyServletRequest.upgrade.md#symbol-0d5040d2fbae739c) — `function`, source line 171
- [getAttribute](EmptyServletRequest.getAttribute.md#symbol-7367559ab01278d1) — `function`, source line 176
- [getAttributeNames](EmptyServletRequest.getAttributeNames.md#symbol-7f794f3a64736703) — `function`, source line 181
- [getCharacterEncoding](EmptyServletRequest.getCharacterEncoding.md#symbol-33e79959b0f9acd4) — `function`, source line 186
- [setCharacterEncoding](EmptyServletRequest.setCharacterEncoding.md#symbol-cc1593665b89f6a5) — `function`, source line 191
- [getContentLength](EmptyServletRequest.getContentLength.md#symbol-4b54469e7c143764) — `function`, source line 196
- [getContentLengthLong](EmptyServletRequest.getContentLengthLong.md#symbol-2b017090ac1d4129) — `function`, source line 201
- [getContentType](EmptyServletRequest.getContentType.md#symbol-f4797eec7f297268) — `function`, source line 206
- [getInputStream](EmptyServletRequest.getInputStream.md#symbol-20c5e039c1f13a78) — `function`, source line 211
- [getParameter](EmptyServletRequest.getParameter.md#symbol-28d14710ed0261e3) — `function`, source line 216
- [getParameterNames](EmptyServletRequest.getParameterNames.md#symbol-2327458e3f39877a) — `function`, source line 221
- [getParameterValues](EmptyServletRequest.getParameterValues.md#symbol-979e8a87e536fcbd) — `function`, source line 226
- [getParameterMap](EmptyServletRequest.getParameterMap.md#symbol-ed218644285161d0) — `function`, source line 231
- [getProtocol](EmptyServletRequest.getProtocol.md#symbol-dfc3917f488e9192) — `function`, source line 236
- [getScheme](EmptyServletRequest.getScheme.md#symbol-c80b36a3731ecd2c) — `function`, source line 241
- [getServerName](EmptyServletRequest.getServerName.md#symbol-d99bd99cd720afad) — `function`, source line 246
- [getServerPort](EmptyServletRequest.getServerPort.md#symbol-d016266c13ed00c4) — `function`, source line 251
- [getReader](EmptyServletRequest.getReader.md#symbol-9d8d10a3e48b39bd) — `function`, source line 256
- [getRemoteAddr](EmptyServletRequest.getRemoteAddr.md#symbol-eec85932d2a1084e) — `function`, source line 261
- [getRemoteHost](EmptyServletRequest.getRemoteHost.md#symbol-4f4e1100a49d9b18) — `function`, source line 266
- [setAttribute](EmptyServletRequest.setAttribute.md#symbol-7553f5720b54e911) — `function`, source line 271
- [removeAttribute](EmptyServletRequest.removeAttribute.md#symbol-c71ceb2b058a53b7) — `function`, source line 276
- [getLocale](EmptyServletRequest.getLocale.md#symbol-8a0996fe500df5ac) — `function`, source line 281
- [getLocales](EmptyServletRequest.getLocales.md#symbol-9d8388d9368be843) — `function`, source line 286
- [isSecure](EmptyServletRequest.isSecure.md#symbol-a2af71d22696d3b2) — `function`, source line 291
- [getRequestDispatcher](EmptyServletRequest.getRequestDispatcher.md#symbol-1e0f91b08a96987c) — `function`, source line 296
- [getRemotePort](EmptyServletRequest.getRemotePort.md#symbol-f1a7a4148c994f8d) — `function`, source line 301
- [getLocalName](EmptyServletRequest.getLocalName.md#symbol-95d55d47e355d2b9) — `function`, source line 306
- [getLocalAddr](EmptyServletRequest.getLocalAddr.md#symbol-68bce338ff65032e) — `function`, source line 311
- [getLocalPort](EmptyServletRequest.getLocalPort.md#symbol-05fc9d391e51ed7d) — `function`, source line 316
- [getServletContext](EmptyServletRequest.getServletContext.md#symbol-795a5c2cd9a6cb01) — `function`, source line 321
- [startAsync](EmptyServletRequest.startAsync--2e602eba97bcf4a9.md#symbol-d6c722216846b8c8) — `function`, source line 326
- [startAsync](EmptyServletRequest.startAsync--ad6bb06fc1f1f17f.md#symbol-952eeb9dd194698f) — `function`, source line 331
- [isAsyncStarted](EmptyServletRequest.isAsyncStarted.md#symbol-1d13695ad66566d8) — `function`, source line 336
- [isAsyncSupported](EmptyServletRequest.isAsyncSupported.md#symbol-79cb84ad8893ecc5) — `function`, source line 341
- [getAsyncContext](EmptyServletRequest.getAsyncContext.md#symbol-e024e7135c01bc85) — `function`, source line 346
- [getDispatcherType](EmptyServletRequest.getDispatcherType.md#symbol-068a8ed952dec2d7) — `function`, source line 351
- [getRequestId](EmptyServletRequest.getRequestId.md#symbol-7def6d42e6f4ecdb) — `function`, source line 356
- [getProtocolRequestId](EmptyServletRequest.getProtocolRequestId.md#symbol-044a1f6c4a222bd9) — `function`, source line 361
- [getServletConnection](EmptyServletRequest.getServletConnection.md#symbol-ad06baa0c45d775a) — `function`, source line 366
