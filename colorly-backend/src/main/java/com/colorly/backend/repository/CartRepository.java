package com.colorly.backend.repository;

import com.colorly.backend.model.Cart;
import com.colorly.backend.model.User;

import org.springframework.data.repository.CrudRepository;


public interface CartRepository extends CrudRepository<Cart, Integer> {
    Cart findByOwner(User owner);
}
