package com.sanix.springBlog.service.impl;

import com.sanix.springBlog.UserRepository;
import com.sanix.springBlog.io.entity.UserEntity;
import com.sanix.springBlog.service.UserService;
import com.sanix.springBlog.shared.Utils;
import com.sanix.springBlog.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user){

        if(userRepository.findByEmail(user.getEmail()) != null ) throw new RuntimeException("Record already exists");

        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId=utils.generateUserId(30);
        userEntity.setUserId(publicUserId);
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        UserEntity storeUserDetails=userRepository.save(userEntity);

        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(storeUserDetails, returnValue);

        return returnValue;
    };
}
