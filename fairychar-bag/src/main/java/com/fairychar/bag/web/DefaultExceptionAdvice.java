package com.fairychar.bag.web;

import com.fairychar.bag.domain.exceptions.DataAlreadyExistException;
import com.fairychar.bag.domain.exceptions.ParamErrorException;
import com.fairychar.bag.domain.exceptions.ServiceException;
import com.fairychar.bag.pojo.vo.HttpResult;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Optional;

/**
 * 基于hibernate validator的参数校验失败全局拦截类
 *
 * @author chiyo <br>
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
        String msg = null;
        if (exception instanceof BindException) {
            msg = Optional
                    .of((BindException) exception)
                    .map(BindException::getAllErrors)
                    .map(errors -> CollectionUtils.isEmpty(errors) ? null : errors.get(0).getObjectName() + ": " + errors.get(0).getDefaultMessage())
                    .orElse(null);
        } else if (exception instanceof ConstraintViolationException) {
            msg = Optional
                    .of((ConstraintViolationException) exception)
                    .map(ConstraintViolationException::getConstraintViolations)
                    .map(constraintViolations -> CollectionUtils.isEmpty(constraintViolations) ? null : constraintViolations.stream().findAny().orElse(null))
                    .map(ConstraintViolation::getMessage)
                    .orElse(null);
        } else if (exception instanceof MethodArgumentNotValidException) {
            msg = Optional
                    .of((MethodArgumentNotValidException) exception)
                    .map(MethodArgumentNotValidException::getBindingResult)
                    .map(Errors::getAllErrors)
                    .map(errors -> CollectionUtils.isEmpty(errors) ? null : errors.get(0).getObjectName() + ": " + errors.get(0).getDefaultMessage())
                    .orElse(null);
        }
        return HttpResult.fail(msg);
    }


    @ExceptionHandler({ParamErrorException.class, DataAlreadyExistException.class})
    public HttpResult handleCheck(ParamErrorException e) {
        return HttpResult.fail(e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public HttpResult handleServiceException(ServiceException e) {
        return new HttpResult(e.getCode(), e.getData(), e.getMessage());
    }


}
