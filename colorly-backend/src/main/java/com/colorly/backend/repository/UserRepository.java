package com.colorly.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.colorly.backend.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    User findByUsername(String username);
}
