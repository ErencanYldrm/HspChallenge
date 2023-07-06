package com.hsp.hspchallenge.service;

import com.hsp.hspchallenge.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(User user);
    User loginUser(String email, String password);

    User getCurrentUser();

    User getUserById(Long id);
    void logoutUser();
}
