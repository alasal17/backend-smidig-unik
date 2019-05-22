package com.westerdals.smidig.controller;



import com.westerdals.smidig.entity.User;
import com.westerdals.smidig.service.MapValidationError;

import com.westerdals.smidig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * This i a control class for Project.
 * The class has an api-path = api/project
 */



@RestController
@RequestMapping("/api/user")
public class UserController {



    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationError mapValidationError;




    // creating a new project
    @PostMapping("")
    public ResponseEntity<?> createNewUser(@Valid@RequestBody User user, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationError.mapValidationResulat(result);

        if(errorMap != null)
            return errorMap;



        User user1 = userService.saveOrUpdateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    // get project by id
    @GetMapping("/{userId}")
    public  ResponseEntity<?> getProjectById(@PathVariable Long userId){

        User user = userService.findUserById(userId);

        return new ResponseEntity<User>(user, HttpStatus.OK);

    }


    @GetMapping("/all")
    public Iterable<User> getAllProjects(){
        return userService.findAllUsers();
    }



    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long userId){
        userService.deleteUserById(userId);

        return  new ResponseEntity<String>("User with ID: '" + userId + "' was deleted",HttpStatus.OK );
    }



}

