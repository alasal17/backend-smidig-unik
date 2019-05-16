package com.westerdals.smidig.service;

import com.westerdals.smidig.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;


@Service
@Transactional
public class UserService {

    @Autowired
    private EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean createUser(String userName, String password) {
        String hashedPassword = passwordEncoder.encode(password);

        if (em.find(User.class, userName) != null) {
            return false;
        }

        User user = new User();
        user.setUserName(userName);
        user.setPassword(hashedPassword);
        em.persist(user);

        return true;
    }

}

