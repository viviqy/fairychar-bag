package com.fairychar.bag.extension.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.catalina.connector.InputBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 克隆http请求request
 * {@link ClonedServletRequest#getInputStream()}方法可以重复读取请求流,每次读取都返回一个原有请求流的clone
 * copy保留:
 * 1.request attribute
 * 2.request headers
 * 3.request method
 * 4.request sessionId
 * 5.request uri
 *
 * @author chiyo
 * @since 3.0.1
 */
public class ClonedServletRequest extends HttpServletRequestWrapper {

    private String method;
    private String requestURI;
    private String sessionId;
    private byte[] inputBytes;

    private Map<String, String> headers;

    private Map<String, Object> attributes;

    public ClonedServletRequest(HttpServletRequest request) {
        super(request);
        try {
            inputBytes = request.getInputStream().readAllBytes();
        } catch (Exception ignore) {
            //ignore
        }
        //copy header
        Enumeration<String> headerNames = request.getHeaderNames();
        this.headers = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            headers.put(key, request.getHeader(key));
        }
        //copy attribute
        Enumeration<String> attributeNames = request.getAttributeNames();
        attributes = new HashMap<>();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            attributes.put(key, request.getAttribute(key));
        }
        //copy requestParam
        this.sessionId = request.getRequestedSessionId();
        this.requestURI = request.getRequestURI();
        this.method = request.getMethod();
    }

    @Override
    public Object getAttribute(String name) {
        return this.attributes.get(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        LinkedList<String> attributeList = this.attributes.keySet().stream().collect(Collectors.toCollection(LinkedList::new));
        return new Enumeration<String>() {
            @Override
            public boolean hasMoreElements() {
                return !attributeList.isEmpty();
            }

            @Override
            public String nextElement() {
                return attributeList.removeFirst();
            }
        };
    }

    @Override
    public String getRequestURI() {
        return this.requestURI;
    }

    @Override
    public String getRequestedSessionId() {
        return this.sessionId;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        LinkedList<String> headerList = this.headers.keySet().stream().collect(Collectors.toCollection(LinkedList::new));
        return new Enumeration<String>() {
            @Override
            public boolean hasMoreElements() {
                return !headerList.isEmpty();
            }

            @Override
            public String nextElement() {
                return headerList.removeFirst();
            }
        };
    }

    @Override
    public String getHeader(String name) {
        return this.headers.get(name);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        InputBuffer ib = new InputBuffer();
        ib.setByteBuffer(ByteBuffer.wrap(inputBytes));
        return new CloneServletInputStream(ib);
    }

}
