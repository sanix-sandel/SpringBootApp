package com.sanix.springBlog.ui.controller;

import com.sanix.springBlog.service.UserService;
import com.sanix.springBlog.shared.dto.UserDto;
import com.sanix.springBlog.ui.model.request.UserDetailsRequestModel;
import com.sanix.springBlog.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired(required=true)
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue=new UserRest();

        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser=userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
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
