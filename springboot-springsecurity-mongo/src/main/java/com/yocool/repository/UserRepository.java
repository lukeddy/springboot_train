package com.yocool.repository;

import com.yocool.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    User findByUsername(String username);
}
