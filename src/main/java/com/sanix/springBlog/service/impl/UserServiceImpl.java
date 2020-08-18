package com.sanix.springBlog.service.impl;

import com.sanix.springBlog.UserRepository;
import com.sanix.springBlog.io.entity.UserEntity;
import com.sanix.springBlog.service.UserService;
import com.sanix.springBlog.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user){

        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");


        UserEntity storeUserDetails=userRepository.save(userEntity);



        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(storeUserDetails, returnValue);

        return returnValue;
    };
}
