package com.westerdals.smidig.service;

import com.westerdals.smidig.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;


@Service
@Transactional
@Stateless
public class UserService {

    @Autowired
    private EntityManager em;
    private User user;





    public void createUser(Long userId, String firstName, String lastName, String userName, String password, int age, String email, int phone, String location) {
        if(isRegistered(userId)){
            return;
        }
        user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassword(password);
        user.setAge(age);
        user.setEmail(email);
        user.setPhone(phone);
        user.setLocation(location);

        em.persist(user);

    }


    public boolean isRegistered(@NotNull Long userId){
        user = em.find(User.class, userId);
        return user != null;
    }

    public long getNumberOfUsers(){
        TypedQuery<Long> query = em.createQuery("select count(*) from User", Long.class);
        long n = query.getSingleResult();
        return n;
    }

    public void addNewUser(String firstName, String lastName,int age, String userName, String password, int phone, String email, String location )
    {
        TypedQuery<User> query = em.createQuery("INSERT INTO USER VALUES" +(firstName +", "+ lastName + ", " + age + ", " +userName +", " + password +", "+ phone + "," + email + "," + location ), User.class );
        query.setMaxResults(1);


    }
}

