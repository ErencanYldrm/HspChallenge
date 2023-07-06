package com.hsp.hspchallenge.repository;

import com.hsp.hspchallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
