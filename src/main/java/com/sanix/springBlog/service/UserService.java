package com.sanix.springBlog.service;

import com.sanix.springBlog.shared.dto.UserDto;


public interface UserService {
    UserDto createUser(UserDto user);
}
