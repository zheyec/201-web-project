package com.colorly.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.colorly.backend.exception.HTTPErrorException;
import com.colorly.backend.model.User;
import com.colorly.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void createUserSession(User user, HttpServletRequest request, HttpSession session) {
        session.invalidate();
        session = request.getSession();
        session.setAttribute("uid", user.getId());
    }

    @PostMapping(path = "/register")
    public User signup(@Valid User user, BindingResult bindingResult, HttpServletRequest request,
            HttpSession session) throws MethodArgumentNotValidException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            bindingResult.rejectValue("username", "username.error", "Username already exists!");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            bindingResult.rejectValue("email", "email.error", "Email already exists!");
        }
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createdUser = userRepository.save(user);
        createUserSession(createdUser, request, session);
        return createdUser;
    }

    @PostMapping(path = "/login")
    public User signin(@RequestParam String username, @RequestParam String password, HttpServletRequest request,
            HttpSession session) {
        User user = userRepository.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new HTTPErrorException(HttpStatus.UNAUTHORIZED, "Invalid username and password pair!");
        }
        createUserSession(user, request, session);
        return user;
    }

    @GetMapping(path = "/info")
    public Object info(HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        if (uid == null) {
            throw new HTTPErrorException(HttpStatus.UNAUTHORIZED, "You are not logged in!");
        }
        return userRepository.findById(uid);
    }

    @GetMapping(path = "/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
