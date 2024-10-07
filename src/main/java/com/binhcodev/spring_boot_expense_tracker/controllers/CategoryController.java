package com.binhcodev.spring_boot_expense_tracker.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binhcodev.spring_boot_expense_tracker.dtos.CategoryDto;
import com.binhcodev.spring_boot_expense_tracker.entities.Category;
import com.binhcodev.spring_boot_expense_tracker.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<Category> createCategory(CategoryDto category) {
        Category newCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
}
