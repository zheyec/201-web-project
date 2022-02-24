package com.colorly.backend.repository;

import com.colorly.backend.model.Item;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
