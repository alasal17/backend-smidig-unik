package com.westerdals.smidig.service;


import com.westerdals.smidig.entity.User;
import com.westerdals.smidig.repository.UserRepository;
import exceptions.ProjectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //add new project, and if the project already exists it will give an error
    public User saveOrUpdateUser(User user){

        try{
            user.setId(user.getId());
            return  userRepository.save(user);
        }catch (Exception e){
            throw new ProjectIdException("User ID " + user.getId() + " already exists");
        }
    }

    // Find project by project Identifier
    public User findUserById(Long userId){

        User user = userRepository.findByUserById(userId);

        if(user ==null){

            throw new ProjectIdException("User ID " + userId + " does not exists");
        }
        return user;

    }


    // Show all projects
    public Iterable<User> findAllUsers(){



        return userRepository.findAll();

    }


    public void deleteUserById(Long userId){
        User user = userRepository.findByUserById(userId);

        if(user == null){
            throw  new ProjectIdException("User with ID '" + userId + "' . This project does not exists");

        }
        userRepository.delete(user);
    }



}