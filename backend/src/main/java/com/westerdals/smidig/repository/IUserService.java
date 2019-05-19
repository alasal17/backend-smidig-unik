package com.westerdals.smidig.repository;

import com.westerdals.smidig.entity.User;

import java.util.List;

public  interface IUserService {

    List<User> findAll();
}
