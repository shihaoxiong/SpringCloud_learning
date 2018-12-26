package com.jay.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 〈user service application  〉
 *
 * @author xsh
 * @date 2018/10/21
 * @since 1.0.0
 */
@SpringBootApplication
@EnableHystrix
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class,args);
    }

}