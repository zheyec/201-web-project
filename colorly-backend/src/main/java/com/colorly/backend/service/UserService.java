package com.colorly.backend.service;

import javax.servlet.http.HttpSession;

import com.colorly.backend.exception.HTTPErrorException;
import com.colorly.backend.model.User;
import com.colorly.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserBySession(HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        if (uid == null) {
            throw new HTTPErrorException(HttpStatus.UNAUTHORIZED, "You are not logged in!");
        }
        return userRepository.findById(uid)
                .orElseThrow(() -> new HTTPErrorException(HttpStatus.NOT_FOUND, "User doesn't exist!"));
    }
}
