package com.hsp.hspchallenge.service;

import com.hsp.hspchallenge.model.Category;
import com.hsp.hspchallenge.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        Category createdCategory = categoryRepository.save(category);
        return createdCategory;
    }


}
