package com.jay.user.service.provider.service;

import com.jay.api.UserService;
import com.jay.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈user service implements   〉
 *
 * @author xsh
 * @date 2018/10/22
 * @since 1.0.0
 */
@Service("inMemoryUserService")
public class InMemoryUserService implements UserService {

    private Map<Long,User> users = new ConcurrentHashMap<>();


    @Override
    public boolean save(User user) {
       return  users.put(user.getId(),user)==null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}