/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fairychar.bag.domain.spring.expression;

import java.lang.reflect.Method;

/**
 * copy from CacheExpressionRootObject
 *
 * @author chiyo
 * @since 1.0.2
 */
public class LockExpressionRootObject {


    private final Method method;

    private final Object[] args;


    public LockExpressionRootObject(
            Method method, Object[] args) {
        this.method = method;
        this.args = args;
    }


    public Method getMethod() {
        return this.method;
    }

    public String getMethodName() {
        return this.method.getName();
    }

    public Object[] getArgs() {
        return this.args;
    }


}
