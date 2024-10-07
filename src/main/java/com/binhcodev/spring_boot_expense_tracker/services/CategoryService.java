package com.binhcodev.spring_boot_expense_tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binhcodev.spring_boot_expense_tracker.dtos.CategoryDto;
import com.binhcodev.spring_boot_expense_tracker.entities.Category;
import com.binhcodev.spring_boot_expense_tracker.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(CategoryDto categoryDto) {
        Category category = Category
                .builder()
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .slug(categoryDto.getSlug())
                .build();
        return categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
