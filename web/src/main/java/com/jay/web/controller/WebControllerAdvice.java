package com.jay.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

/**
 * 〈advice  捕获并处理异常 〉
 *
 * @author xsh
 * @date 2018/10/21
 * @since 1.0.0
 */
@RestControllerAdvice
public class WebControllerAdvice {


    @ExceptionHandler(TimeoutException.class)
    public  String timeoutHandler(Throwable throwable){
        return throwable.getMessage();
    }


}