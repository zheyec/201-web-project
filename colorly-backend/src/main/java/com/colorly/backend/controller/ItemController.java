package com.colorly.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.colorly.backend.model.Item;
import com.colorly.backend.repository.ItemRepository;
import com.colorly.backend.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/search")
    public List<Item> search(@RequestParam String color1, @RequestParam String color2, @RequestParam String color3) {
        return itemService.search(color1, color2, color3);
    }

    @GetMapping(path = "/all")
    public List<Item> getAll() {
        List<Item> result = new ArrayList<Item>();
        itemRepository.findAll().forEach(result::add);
        return result;
    }
}
