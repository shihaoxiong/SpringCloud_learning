package com.jay.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * 〈 controller demo  〉
 *
 * @author xsh
 * @date 2018/10/21
 * @since 1.0.0
 */
@RestController
public class WebRestController {

    private static final Random random  = new Random();

    @GetMapping("/timeout")
    public  String timeoutTest() throws  Exception{

        int executeTimeout = random.nextInt(200);

        if (executeTimeout>100){
            throw new  TimeoutException("execute timeout ! ! ! ");
        }

        return "hello world ! ";
    }


}