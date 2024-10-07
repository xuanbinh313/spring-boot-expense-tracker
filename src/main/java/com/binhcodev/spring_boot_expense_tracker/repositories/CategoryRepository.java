package com.binhcodev.spring_boot_expense_tracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.binhcodev.spring_boot_expense_tracker.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
