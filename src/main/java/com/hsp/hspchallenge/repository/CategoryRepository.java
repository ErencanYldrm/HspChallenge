package com.hsp.hspchallenge.repository;

import com.hsp.hspchallenge.model.Category;
import com.hsp.hspchallenge.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
