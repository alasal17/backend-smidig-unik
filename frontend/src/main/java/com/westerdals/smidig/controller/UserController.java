package com.westerdals.smidig.controller;


import com.westerdals.smidig.entity.User;
import com.westerdals.smidig.repository.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("showUser")
    public String findUsers(Model model){

        List users = (List<User>) userService.findAll();

        model.addAttribute("users", users);

        return "showUsers;";
    }
}
