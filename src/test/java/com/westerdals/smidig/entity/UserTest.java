package com.westerdals.smidig.entity;

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
}
