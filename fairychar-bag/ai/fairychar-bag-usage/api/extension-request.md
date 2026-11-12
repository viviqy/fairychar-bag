# `com.fairychar.bag.extension.request`

[返回 API 索引](README.md)

[CloneServletInputStream](#extension-request-cloneservletinputstream) · [ClonedServletRequest](#extension-request-clonedservletrequest) · [EmptyServletRequest](#extension-request-emptyservletrequest)

<a id="extension-request-cloneservletinputstream"></a>

## `com.fairychar.bag.extension.request.CloneServletInputStream`

类型声明：

```java
public class com.fairychar.bag.extension.request.CloneServletInputStream
```

使用说明：[features/web/request-wrapper.md](../features/web/request-wrapper.md)。

父类：`org.apache.catalina.connector.CoyoteInputStream`。

### public 构造器

```java
public com.fairychar.bag.extension.request.CloneServletInputStream(org.apache.catalina.connector.InputBuffer)
```

### 当前类型声明的 public 方法

无。

### public 字段 / 枚举常量

无。

<a id="extension-request-clonedservletrequest"></a>

## `com.fairychar.bag.extension.request.ClonedServletRequest`

类型声明：

```java
public class com.fairychar.bag.extension.request.ClonedServletRequest
```

使用说明：[features/web/request-wrapper.md](../features/web/request-wrapper.md)。

父类：`jakarta.servlet.http.HttpServletRequestWrapper`。

### public 构造器

```java
public com.fairychar.bag.extension.request.ClonedServletRequest(jakarta.servlet.http.HttpServletRequest)
```

### 当前类型声明的 public 方法

```java
public jakarta.servlet.ServletInputStream com.fairychar.bag.extension.request.ClonedServletRequest.getInputStream() throws java.io.IOException
public java.lang.Object com.fairychar.bag.extension.request.ClonedServletRequest.getAttribute(java.lang.String)
public java.lang.String com.fairychar.bag.extension.request.ClonedServletRequest.getHeader(java.lang.String)
public java.lang.String com.fairychar.bag.extension.request.ClonedServletRequest.getMethod()
public java.lang.String com.fairychar.bag.extension.request.ClonedServletRequest.getRequestURI()
public java.lang.String com.fairychar.bag.extension.request.ClonedServletRequest.getRequestedSessionId()
public java.util.Enumeration<java.lang.String> com.fairychar.bag.extension.request.ClonedServletRequest.getAttributeNames()
public java.util.Enumeration<java.lang.String> com.fairychar.bag.extension.request.ClonedServletRequest.getHeaderNames()
```

### public 字段 / 枚举常量

无。

<a id="extension-request-emptyservletrequest"></a>

## `com.fairychar.bag.extension.request.EmptyServletRequest`

类型声明：

```java
public class com.fairychar.bag.extension.request.EmptyServletRequest
```

使用说明：[features/web/request-wrapper.md](../features/web/request-wrapper.md)。

父类：`java.lang.Object`。

接口：`jakarta.servlet.http.HttpServletRequest`。

### public 构造器

```java
public com.fairychar.bag.extension.request.EmptyServletRequest()
```

### 当前类型声明的 public 方法

```java
public <T extends jakarta.servlet.http.HttpUpgradeHandler> T com.fairychar.bag.extension.request.EmptyServletRequest.upgrade(java.lang.Class<T>) throws java.io.IOException,jakarta.servlet.ServletException
public boolean com.fairychar.bag.extension.request.EmptyServletRequest.authenticate(jakarta.servlet.http.HttpServletResponse) throws java.io.IOException,jakarta.servlet.ServletException
public boolean com.fairychar.bag.extension.request.EmptyServletRequest.isAsyncStarted()
public boolean com.fairychar.bag.extension.request.EmptyServletRequest.isAsyncSupported()
public boolean com.fairychar.bag.extension.request.EmptyServletRequest.isRequestedSessionIdFromCookie()
public boolean com.fairychar.bag.extension.request.EmptyServletRequest.isRequestedSessionIdFromURL()
public boolean com.fairychar.bag.extension.request.EmptyServletRequest.isRequestedSessionIdValid()
public boolean com.fairychar.bag.extension.request.EmptyServletRequest.isSecure()
public boolean com.fairychar.bag.extension.request.EmptyServletRequest.isUserInRole(java.lang.String)
public int com.fairychar.bag.extension.request.EmptyServletRequest.getContentLength()
public int com.fairychar.bag.extension.request.EmptyServletRequest.getIntHeader(java.lang.String)
public int com.fairychar.bag.extension.request.EmptyServletRequest.getLocalPort()
public int com.fairychar.bag.extension.request.EmptyServletRequest.getRemotePort()
public int com.fairychar.bag.extension.request.EmptyServletRequest.getServerPort()
public jakarta.servlet.AsyncContext com.fairychar.bag.extension.request.EmptyServletRequest.getAsyncContext()
public jakarta.servlet.AsyncContext com.fairychar.bag.extension.request.EmptyServletRequest.startAsync() throws java.lang.IllegalStateException
public jakarta.servlet.AsyncContext com.fairychar.bag.extension.request.EmptyServletRequest.startAsync(jakarta.servlet.ServletRequest,jakarta.servlet.ServletResponse) throws java.lang.IllegalStateException
public jakarta.servlet.DispatcherType com.fairychar.bag.extension.request.EmptyServletRequest.getDispatcherType()
public jakarta.servlet.RequestDispatcher com.fairychar.bag.extension.request.EmptyServletRequest.getRequestDispatcher(java.lang.String)
public jakarta.servlet.ServletConnection com.fairychar.bag.extension.request.EmptyServletRequest.getServletConnection()
public jakarta.servlet.ServletContext com.fairychar.bag.extension.request.EmptyServletRequest.getServletContext()
public jakarta.servlet.ServletInputStream com.fairychar.bag.extension.request.EmptyServletRequest.getInputStream() throws java.io.IOException
public jakarta.servlet.http.Cookie[] com.fairychar.bag.extension.request.EmptyServletRequest.getCookies()
public jakarta.servlet.http.HttpSession com.fairychar.bag.extension.request.EmptyServletRequest.getSession()
public jakarta.servlet.http.HttpSession com.fairychar.bag.extension.request.EmptyServletRequest.getSession(boolean)
public jakarta.servlet.http.Part com.fairychar.bag.extension.request.EmptyServletRequest.getPart(java.lang.String) throws java.io.IOException,jakarta.servlet.ServletException
public java.io.BufferedReader com.fairychar.bag.extension.request.EmptyServletRequest.getReader() throws java.io.IOException
public java.lang.Object com.fairychar.bag.extension.request.EmptyServletRequest.getAttribute(java.lang.String)
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.changeSessionId()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getAuthType()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getCharacterEncoding()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getContentType()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getContextPath()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getHeader(java.lang.String)
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getLocalAddr()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getLocalName()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getMethod()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getParameter(java.lang.String)
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getPathInfo()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getPathTranslated()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getProtocol()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getProtocolRequestId()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getQueryString()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getRemoteAddr()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getRemoteHost()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getRemoteUser()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getRequestId()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getRequestURI()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getRequestedSessionId()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getScheme()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getServerName()
public java.lang.String com.fairychar.bag.extension.request.EmptyServletRequest.getServletPath()
public java.lang.StringBuffer com.fairychar.bag.extension.request.EmptyServletRequest.getRequestURL()
public java.lang.String[] com.fairychar.bag.extension.request.EmptyServletRequest.getParameterValues(java.lang.String)
public java.security.Principal com.fairychar.bag.extension.request.EmptyServletRequest.getUserPrincipal()
public java.util.Collection<jakarta.servlet.http.Part> com.fairychar.bag.extension.request.EmptyServletRequest.getParts() throws java.io.IOException,jakarta.servlet.ServletException
public java.util.Enumeration<java.lang.String> com.fairychar.bag.extension.request.EmptyServletRequest.getAttributeNames()
public java.util.Enumeration<java.lang.String> com.fairychar.bag.extension.request.EmptyServletRequest.getHeaderNames()
public java.util.Enumeration<java.lang.String> com.fairychar.bag.extension.request.EmptyServletRequest.getHeaders(java.lang.String)
public java.util.Enumeration<java.lang.String> com.fairychar.bag.extension.request.EmptyServletRequest.getParameterNames()
public java.util.Enumeration<java.util.Locale> com.fairychar.bag.extension.request.EmptyServletRequest.getLocales()
public java.util.Locale com.fairychar.bag.extension.request.EmptyServletRequest.getLocale()
public java.util.Map<java.lang.String, java.lang.String[]> com.fairychar.bag.extension.request.EmptyServletRequest.getParameterMap()
public long com.fairychar.bag.extension.request.EmptyServletRequest.getContentLengthLong()
public long com.fairychar.bag.extension.request.EmptyServletRequest.getDateHeader(java.lang.String)
public void com.fairychar.bag.extension.request.EmptyServletRequest.login(java.lang.String,java.lang.String) throws jakarta.servlet.ServletException
public void com.fairychar.bag.extension.request.EmptyServletRequest.logout() throws jakarta.servlet.ServletException
public void com.fairychar.bag.extension.request.EmptyServletRequest.removeAttribute(java.lang.String)
public void com.fairychar.bag.extension.request.EmptyServletRequest.setAttribute(java.lang.String,java.lang.Object)
public void com.fairychar.bag.extension.request.EmptyServletRequest.setCharacterEncoding(java.lang.String) throws java.io.UnsupportedEncodingException
```

### public 字段 / 枚举常量

无。

