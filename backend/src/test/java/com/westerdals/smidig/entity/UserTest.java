package com.westerdals.smidig.entity;

import com.westerdals.smidig.service.UserService;
import org.junit.jupiter.api.Test;

public class UserTest {



    @Test
    public void createUserTest(){
        User user = new User();
        user.setFirstName("Håkon");
        user.setLastName("Larsen");
        user.setUserName("LarHåk");
        user.setAge(25);
        user.setPhone(90909090);
        user.setEmail("håkon@gmail.com");
        user.setLocation("Oslo");
    }


    @Test
    public void getUserTest(){
        User user = new User();
        user.getId();
        user.getFirstName();
        user.getLastName();
        user.getEmail();
        user.getAge();
        user.getLocation();
        user.getPhone();
        user.getUserName();
        user.getPassword();
    }



}
