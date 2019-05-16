package com.westerdals.smidig.entity;

import com.westerdals.smidig.service.UserService;
import org.junit.jupiter.api.Test;

public class UserServiceTest {


    @Test
    public void createUser(){
        UserService userService = new UserService();
        userService.createUser("gest","1234");


    }
}

