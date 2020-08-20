package com.sanix.springBlog.io.repositories;

import com.sanix.springBlog.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserEntity, Long>{

    UserEntity findByEmail(String email);
}
