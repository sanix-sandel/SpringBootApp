package com.sanix.springBlog;

import com.sanix.springBlog.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserEntity, Long>{

    UserEntity findByEmail(String email);
}
