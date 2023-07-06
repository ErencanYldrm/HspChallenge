package com.hsp.hspchallenge.service;

import com.hsp.hspchallenge.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Category createCategory(Category category);
}
