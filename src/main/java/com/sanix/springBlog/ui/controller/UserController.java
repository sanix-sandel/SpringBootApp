package com.sanix.springBlog.ui.controller;

import com.sanix.springBlog.ui.model.request.UserDetailsRequestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(){
        return "get user called";
    }

    @PostMapping
    public String createUser(@RequestBody UserDetailsRequestModel userDetails){
        return "create user was called";
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
