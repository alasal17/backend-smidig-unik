package com.westerdals.smidig.service;

import com.westerdals.smidig.entity.User;
import com.westerdals.smidig.repository.IUserService;
import com.westerdals.smidig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;


    public boolean createUser(String firstName, String lastName, int age, String email, String location, int phone, String userName, String password) {
        String hashedPassword = passwordEncoder.encode(password);

        if (em.find(User.class, userName) != null) {
            return false;
        }

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setEmail(email);
        user.setLocation(location);
        user.setPhone(phone);
        user.setUserName(userName);
        user.setPassword(hashedPassword);
        em.persist(user);

        return true;
    }


    @Override
    public List<User> findAll() {


        return (List<User>) repository.findAll();
    }
}

