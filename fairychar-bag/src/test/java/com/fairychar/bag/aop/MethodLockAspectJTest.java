package com.fairychar.bag.aop;

import com.fairychar.bag.domain.annotations.MethodLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * MethodLockAspectJ 测试类
 * 
 * @author chiyo
 * @since 1.0
 */
public class MethodLockAspectJTest {

    @Test
    public void testLockDisabledShouldProceedNormally() throws Throwable {
        // Arrange: 创建一个MethodLockAspectJ实例
        MethodLockAspectJ aspect = new MethodLockAspectJ();
        
        // 创建一个ProceedingJoinPoint mock
        final Object expectedResult = "testResult";
        ProceedingJoinPoint joinPoint = new ProceedingJoinPoint() {
            private boolean proceeded = false;
            
            @Override
            public Object proceed() throws Throwable {
                proceeded = true;
                return expectedResult;
            }
            
            @Override
            public Object proceed(Object[] args) throws Throwable {
                proceeded = true;
                return expectedResult;
            }
            
            @Override
            public Object getTarget() {
                return null;
            }
            
            @Override
            public Object getThis() {
                return null;
            }
            
            @Override
            public Object[] getArgs() {
                return new Object[0];
            }
            
            @Override
            public MethodSignature getSignature() {
                return null;
            }
            
            @Override
            public org.aspectj.lang.Signature getStaticPart() {
                return null;
            }
            
            @Override
            public String getKind() {
                return null;
            }
            
            @Override
            public int getId() {
                return 0;
            }
            
            public boolean isProceeded() {
                return proceeded;
            }
        };
        
        // 创建一个禁用的MethodLock注解
        MethodLock disabledLock = new MethodLock() {
            @Override
            public Type lockType() {
                return Type.LOCAL;
            }
            
            @Override
            public boolean enable() {
                return false; // 禁用锁
            }
            
            @Override
            public int timeout() {
                return -1;
            }
            
            @Override
            public boolean optimistic() {
                return false;
            }
            
            @Override
            public java.util.concurrent.TimeUnit timeUnit() {
                return java.util.concurrent.TimeUnit.NANOSECONDS;
            }
            
            @Override
            public String nameExpression() {
                return "";
            }
            
            @Override
            public String distributedPrefix() {
                return "fairychar:lock:";
            }
            
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() {
                return MethodLock.class;
            }
        };
        
        // Act: 调用locking方法
        Object result = aspect.locking(joinPoint, disabledLock);
        
        // Assert: 验证结果不为null，并且是预期的结果
        assertNotNull("当锁禁用时，应该返回正常结果而不是null", result);
        assertEquals("应该返回joinPoint.proceed()的结果", expectedResult, result);
    }
}
