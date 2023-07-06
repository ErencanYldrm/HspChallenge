package com.hsp.hspchallenge.controller;


import com.hsp.hspchallenge.model.User;
import com.hsp.hspchallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        User user = userService.loginUser(email, password);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/current-user")
    public ResponseEntity<User> getCurrentUser() {
        User currentUser = userService.getCurrentUser();
        if (currentUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(currentUser);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }



    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser() {
        userService.logoutUser();
        return ResponseEntity.ok().build();
    }
}
