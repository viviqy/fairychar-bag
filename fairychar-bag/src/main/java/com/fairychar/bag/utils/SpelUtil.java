package com.fairychar.bag.utils;

import com.fairychar.bag.domain.spring.expression.SimpleEvaluationContext;
import com.fairychar.bag.domain.spring.expression.SimpleExpressionRootObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.lang.reflect.Method;

/**
 * spel util
 *
 * @author chiyo <br>
 * @date
 */
public class SpelUtil {
    private final static ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
    private final static SpelExpressionParser spelExpressionParser = new SpelExpressionParser();


    /**
     * 评估
     *
     * @param expression 表达
     * @param joinPoint  加入点
     * @param returnType 返回类型
     * @return {@code T }
     */
    public static <T> T eval(String expression, JoinPoint joinPoint, Class<T> returnType) {
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        T eval = SpelUtil.eval(expression, method, proceedingJoinPoint.getArgs(), returnType);
        return eval;
    }


    /**
     * 计算spel值
     *
     * @param expression 表达式
     * @param method     aop切入得我方法
     * @param args       aop切入方法的参数
     * @return {@code T }
     */
    public static <T> T eval(String expression, Method method, Object[] args, Class<T> returnType) {
        Expression parsedExpression = parseExpression(expression);
        EvaluationContext evaluationContext = createEvaluationContext(method, args);
        Object value = parsedExpression.getValue(evaluationContext);
        return (T) value;
    }


    /**
     * 创建Spel上下文
     *
     * @param method 方法
     * @param args   参数
     * @return {@code EvaluationContext }
     */
    public static EvaluationContext createEvaluationContext(Method method, Object[] args) {
        SimpleExpressionRootObject rootObject = new SimpleExpressionRootObject(method, args);
        SimpleEvaluationContext evaluationContext = new SimpleEvaluationContext(rootObject, method, args, parameterNameDiscoverer);
        return evaluationContext;
    }


    /**
     * 解析表达式
     *
     * @param expression 表达
     * @return {@code Expression }
     */
    public static Expression parseExpression(String expression) {
        Expression parseExpression = spelExpressionParser.parseExpression(expression);
        return parseExpression;
    }

}
