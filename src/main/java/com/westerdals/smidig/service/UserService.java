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





    public void createUser(String firstName, String lastName, boolean enable, String userName, String password, int age, String email, int phone, String location) {
        if(isRegistered(userName)){
            return;
        }
        User user = new User();
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


    public boolean isRegistered(@NotNull String userId){
        User user = em.find(User.class, userId);
        return user != null;
    }

    public long getNumberOfUsers(){
        TypedQuery<Long> query = em.createQuery("select count(u) from User u", Long.class);
        long n = query.getSingleResult();
        return n;
    }

    public void addNewUser(String firstName, String lastName, int counter, String username, String password, boolean enabled )
    {
        TypedQuery<User> query = em.createQuery("INSERT INTO USERS VALUES" +(firstName +", "+ lastName +", "+counter +", "+ username +", "+ password +", "+ enabled ), User.class );
        query.setMaxResults(counter);


    }
}

