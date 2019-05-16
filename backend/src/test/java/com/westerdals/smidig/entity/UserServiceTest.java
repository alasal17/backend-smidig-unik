package com.westerdals.smidig.entity;

import com.westerdals.smidig.service.UserService;
import org.junit.jupiter.api.Test;

public class UserServiceTest {


    @Test
    public void addUser(){
        UserService userService = new UserService();
        userService.addNewUser("ole","mar",25,"ole","ewr",000000,"ole@gmail.com","Oslo");
    }
}
