package com.jay.api;

import com.jay.domain.User;
import com.jay.fallback.UserServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 〈user service  〉
 * @author xsh
 * @date 2018/10/21
 * @since 1.0.0
 */
@FeignClient(name = "${user.service.name}",fallback = UserServiceFallback.class)
public interface UserService {

    /**
     *  保存 User
     * @param user 要保存的user
     * @return 执行结果
     */
    @GetMapping("/user/save")
    boolean save(User user);

    /**
     *
     * @return 所有的user
     */
    @GetMapping("/user/find/all")
    List<User> findAll();

}