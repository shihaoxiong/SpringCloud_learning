package com.jay.user.service.web.controller;

import com.jay.api.UserService;
import com.jay.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 〈user srevice controller 〉
 *
 * @author xsh
 * @date 2018/10/22
 * @since 1.0.0
 */
@RestController
public class UserServiceProviderController implements UserService{

    public  static  final Random  random = new Random();

    // 通过方法继承，URL 映射 ："/user/save"
    @Override
    public boolean save(User user) {
        return userService.save(user);
    }

    @HystrixCommand(
            commandProperties = { // Command 配置
                    // 设置操作时间为 100 毫秒
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            },
            fallbackMethod = "fallbackForGetUsers"
    )
    // 通过方法继承，URL 映射 ："/user/find/all"
    @Override
    public List<User> findAll() {
        return userService.findAll();
    }



    @Autowired
    @Qualifier("inMemoryUserService")
    private UserService userService;

    //@GetMapping("/user/save")
    public  boolean userSave(User user){
        return userService.save(user);
    }

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds", value = "100" )
            },
            fallbackMethod = "fallbackForGetUsers"
    )
    @GetMapping("/user/list")
    public Collection<User>  getUsers () throws  InterruptedException{
        long executeTime = random.nextInt(200);

        // 通过休眠来模拟执行时间
        System.out.println("Execute Time : " + executeTime + " ms");

        Thread.sleep(executeTime);

        return userService.findAll();
    }

    /**
     * {@link #getUsers()} 的 fallback 方法  返回值一定要对应
     *
     * @return 空集合
     */
    public Collection<User> fallbackForGetUsers() {
        return Collections.emptyList();
    }


}