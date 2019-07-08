package com.lxy.springmvcdemo.controller;

import com.alibaba.fastjson.JSON;
import com.lxy.demo.common.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * @author liuxinyun
 * @date 2019/7/7 20:20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultData handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("handleHttpMessageNotReadableException : " + e.getMessage(), e);
        return ResultData.failed("参数解析失败");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultData handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder("Invalid Request:");

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getCodes()[1]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);//删除最后的符号
        return ResultData.failed(sb.toString());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResultData handleNullPointerException(HttpServletRequest request, NullPointerException e) {
        logger.error("handleNullPointerException : requestParams:" + JSON.toJSONString(request.getParameterMap()), e);
        return ResultData.failed("操作异常(空)");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResultData handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        logger.error("handleIllegalArgumentException : requestParams:" + JSON.toJSONString(request.getParameterMap()), e);
        return ResultData.failed(e.getMessage());
    }

    /**
     * 使用反射出现的异常想要打印异常信息需要使用getTargetException()获取真正的异常
     */
    @ExceptionHandler(InvocationTargetException.class)
    public ResultData handleInvocationTargetException(HttpServletRequest request, InvocationTargetException e) {
        logger.error("handleInvocationTargetException : requestParams:" + JSON.toJSONString(request.getParameterMap()), e.getTargetException());
        return ResultData.failed(e.getTargetException().getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultData handleException(HttpServletRequest request, Exception e) {
        logger.error("handleException : requestParams:" + JSON.toJSONString(request.getParameterMap()), e);
        return ResultData.failed(e.getMessage());
    }

}
