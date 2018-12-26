package com.jay.fallback;

import com.google.common.collect.Lists;
import com.jay.api.UserService;
import com.jay.domain.User;

import java.util.List;

/**
 *
 * @author xsh
 * @date 2018/10/23
 * @since 1.0.0
 */
public class UserServiceFallback implements UserService {

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return Lists.newArrayList();
    }

}