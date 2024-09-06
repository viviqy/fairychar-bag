package com.fairychar.bag.web;

import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.ServiceException;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fairychar.bag.pojo.vo.InvalidateFieldVO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于hibernate validator的参数校验失败全局拦截类
 *
 * @author chiyo
 * @since 0.0.1
 */
@RestControllerAdvice
public class DefaultExceptionAdvice {
    /**
     * 只返回第一个校验失败的参数的校验原因
     * 该类错误可以从返回体中获取失败原因， 因此无需打印error
     * 处理参数格式校验失败错误 处理范围
     * 一Get请求中 标记@Valid的参数实体
     * 二@RequestParam 上标记@Validate的参数实体
     * 三@RequestBody 上标记@Validate的参数实体
     *
     * @param exception 异常
     * @return 包装返回体
     */
    @ExceptionHandler(value = {BindException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public HttpResult paramsException(Exception exception) {
        List<InvalidateFieldVO> invalidateFieldVOS = new ArrayList<>(0);
        if (exception instanceof BindException be) {
            invalidateFieldVOS = be.getFieldErrors().stream()
                    .map(error -> new InvalidateFieldVO(error.getField(), error.getDefaultMessage()))
                    .toList();
        } else if (exception instanceof ConstraintViolationException ce) {
            invalidateFieldVOS = ce.getConstraintViolations().stream()
                    .map(error -> new InvalidateFieldVO(error.getPropertyPath().toString(), error.getMessage()))
                    .toList();
        } else if (exception instanceof MethodArgumentNotValidException me) {
            invalidateFieldVOS = me.getBindingResult().getFieldErrors().stream()
                    .map(error -> new InvalidateFieldVO(error.getField(), error.getDefaultMessage()))
                    .toList();
        }
        return HttpResult.fail(RestErrorCode.PARAM_INVALIDATE, invalidateFieldVOS);
    }


    @ExceptionHandler(ServiceException.class)
    public HttpResult handleServiceException(ServiceException e) {
        return new HttpResult(e.getCode(), e.getData(), e.getMessage());
    }


}
