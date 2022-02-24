package com.colorly.backend.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.colorly.backend.exception.HTTPErrorException;
import com.colorly.backend.model.Cart;
import com.colorly.backend.model.Item;
import com.colorly.backend.model.Outfit;
import com.colorly.backend.model.User;
import com.colorly.backend.repository.CartRepository;
import com.colorly.backend.repository.ItemRepository;
import com.colorly.backend.repository.OutfitRepository;
import com.colorly.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OutfitRepository outfitRepository;

    @Autowired
    private UserService userService;

    private Cart forceGetCart(HttpSession session) {
        User user = userService.getUserBySession(session);
        Cart cart = cartRepository.findByOwner(user);
        if (cart == null) {
            cart = new Cart();
            cart.setItems(new HashSet<Item>());
            cart.setOwner(user);
            cartRepository.save(cart);
        }
        return cart;
    }

    @GetMapping(path = "/items")
    public Set<Item> cartItems(HttpSession session) {
        return forceGetCart(session).getItems();
    }

    @PutMapping(path = "/items/{itemId}")
    public void addItem(@PathVariable Integer itemId, HttpSession session) {
        Cart cart = forceGetCart(session);
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new HTTPErrorException(HttpStatus.NOT_FOUND, "Item doesn't exist!"));
        cart.addItem(item);
        cartRepository.save(cart);
    }

    @DeleteMapping(path = "/items/{itemId}")
    public void deleteItem(@PathVariable Integer itemId, HttpSession session) {
        Cart cart = forceGetCart(session);
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new HTTPErrorException(HttpStatus.NOT_FOUND, "Item doesn't exist!"));
        cart.removeItem(item);
        cartRepository.save(cart);
    }

    @GetMapping(path = "/publish")
    public Outfit publish(HttpSession session) {
        Cart cart = forceGetCart(session);
        if (cart.getItems().size() == 0) {
            throw new HTTPErrorException(HttpStatus.BAD_REQUEST, "Cart is empty!");
        }
        Outfit outfit = new Outfit();
        outfit.setOwner(cart.getOwner());
        outfit.setLikers(new HashSet<User>());
        outfit.setItems(new HashSet<Item>(cart.getItems()));
        return outfitRepository.save(outfit);
    }
}
