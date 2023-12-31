package com.hsp.hspchallenge.service;

import com.hsp.hspchallenge.model.User;
import com.hsp.hspchallenge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private User currentUser;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    public User getUserById(Long id){
        return userRepository.getUserById(id);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return user;
        }
        return null;
    }

    public void logoutUser() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User updateUser(User user) {
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public void updateUserBalance(BigDecimal amount) {
        if(currentUser == null) {
            return;
        }
        currentUser.setBalance(amount);
        userRepository.save(currentUser);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
