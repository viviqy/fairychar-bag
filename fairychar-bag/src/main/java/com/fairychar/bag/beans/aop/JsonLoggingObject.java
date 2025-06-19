package com.fairychar.bag.beans.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chiyo <br>
 * @since
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
class JsonLoggingObject implements Serializable {
    private String action;
    private String controller;
    private String methodName;
    private String httpMethod;
    private String traceId;
    private String ip;
    private String uri;
    private Object body;
}
