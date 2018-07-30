package com.liuyanzhao.cloud.core.service.impl;

import com.liuyanzhao.cloud.api.model.User;
import com.liuyanzhao.cloud.core.mapper.UserMapper;
import com.liuyanzhao.cloud.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 言曌
 * @date 2018/7/29 下午6:16
 */
@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userMapper.findById(id);
    }

    @Override
    @GetMapping("/user")
    public List<User> listUsers() {
        return userMapper.findAll();
    }

    @Override
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userMapper.update(user);
    }

    @Override
    @PostMapping("/user")
    public User insertUser(@RequestBody User user) {
        Integer userId = userMapper.insert(user);
        user.setId(userId);
        return user;
    }
}
