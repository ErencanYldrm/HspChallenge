package com.hsp.hspchallenge.UserTest;

import com.hsp.hspchallenge.controller.UserController;
import com.hsp.hspchallenge.model.User;
import com.hsp.hspchallenge.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.ResponseEntity.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {
    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;


    @Test
    void ItShouldCreateUser() {
        User user = new User("test","test","test", new BigDecimal("1000.00"));
        ResponseEntity<User> response = userController.createUser(user);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void loginUser() {
        User user = new User("test","test","test", new BigDecimal("1000.00"));
        userService.createUser(user);
        Map<String, String> credentials = Map.of("email", "test", "password", "test");
        ResponseEntity<User> response = userController.loginUser(credentials);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void ItShouldGetCurrentUser() {
        User user = new User("test","test2","test2", new BigDecimal("1000.00"));
        userService.createUser(user);
        Map<String, String> credentials = Map.of("email", "test2", "password", "test2");
        ResponseEntity<User> response = userController.loginUser(credentials);
        assertEquals(status(HttpStatus.OK).body(user) , userController.getCurrentUser());

    }
}