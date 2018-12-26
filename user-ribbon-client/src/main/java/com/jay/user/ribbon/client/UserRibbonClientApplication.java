package com.jay.user.ribbon.client;

import com.jay.api.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 〈spring  〉
 *
 * @author xsh
 * @date 2018/10/21
 * @since 1.0.0
 */
@SpringBootApplication
@RibbonClient("user-service-provider") // 指定目标应用名称
@EnableCircuitBreaker
@EnableFeignClients(clients = UserService.class)  // 激活Feign
public class UserRibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRibbonClientApplication.class,args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}