package com.sanix.springBlog.ui.controller;

import com.sanix.springBlog.ui.model.request.UserDetailsRequestModel;
import com.sanix.springBlog.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(){
        return "get user called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        return null;
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
