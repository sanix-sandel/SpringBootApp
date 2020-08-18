package com.sanix.springBlog.service;

import com.sanix.springBlog.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
}
