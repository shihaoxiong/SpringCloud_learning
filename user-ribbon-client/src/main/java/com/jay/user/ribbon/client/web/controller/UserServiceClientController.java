package com.jay.user.ribbon.client.web.controller;

import com.jay.api.UserService;
import com.jay.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈UserServiceClientController 〉
 * @author xsh
 * @date 2018/10/23
 * @since 1.0.0
 */
@RestController
public class UserServiceClientController    {

    @Autowired
    private UserService userService;

    // 通过方法继承，URL 映射 ："/user/save"
    @GetMapping("/user/save")
    public boolean save( User user) {
        return userService.save(user);
    }

    @GetMapping("/user/find/all")
    // 通过方法继承，URL 映射 ："/user/find/all"
    public List<User> findAll() {
        return userService.findAll();
    }

}