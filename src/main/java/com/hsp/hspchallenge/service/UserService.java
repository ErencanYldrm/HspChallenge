package com.hsp.hspchallenge.service;

import com.hsp.hspchallenge.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User loginUser(String email, String password);

    User getCurrentUser();

    User getUserById(Long id);

    void logoutUser();

    void updateUserBalance(BigDecimal amount);

    List<User> getAllUsers();

    User updateUser(User user);
}
