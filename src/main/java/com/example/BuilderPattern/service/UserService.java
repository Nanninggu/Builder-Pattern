package com.example.BuilderPattern.service;

import com.example.BuilderPattern.dto.User;
import com.example.BuilderPattern.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findByName(String name) {
        return userMapper.findByName(name).build();
    }

    public void userBuilder() {
        User user = new User.UserBuilder()
                .setName("Seung Kim")
                .setEmail("Seungkim@example.com")
                .build();
        userMapper.insertUser(user);
    }

    public void userBuilderForEmail() {
        User user = new User.UserBuilder()
                .setEmail("Seungkim@example.com")
                .build();
        userMapper.insertUser(user);
    }
    

}