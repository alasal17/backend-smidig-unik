package com.westerdals.smidig.entity;

import com.westerdals.smidig.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;

public class UserServiceTest {

    @Autowired
    private EntityManager em;

    private User user;


    @Autowired
    private PasswordEncoder passwordEncoder;
    private String password;
    private String userName;


    @Test
    public boolean createUser(){
        String hashedPassword = passwordEncoder.encode(password);

        if (em.find(User.class, userName) != null) {
            return false;
        }
        UserService userService = new UserService();
        userService.createUser("ole","martin", 25,"ole@gmail.com","oslo",00000,"olemarting",hashedPassword);
        em.persist(user);
        return true;
    }
}

