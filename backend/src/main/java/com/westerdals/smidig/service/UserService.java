package com.westerdals.smidig.service;


import com.westerdals.smidig.entity.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}