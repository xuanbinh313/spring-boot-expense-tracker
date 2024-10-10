package com.binhcodev.spring_boot_expense_tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binhcodev.spring_boot_expense_tracker.dtos.ExpenseDto;
import com.binhcodev.spring_boot_expense_tracker.entities.Category;
import com.binhcodev.spring_boot_expense_tracker.entities.Expense;
import com.binhcodev.spring_boot_expense_tracker.entities.User;
import com.binhcodev.spring_boot_expense_tracker.repositories.CategoryRepository;
import com.binhcodev.spring_boot_expense_tracker.repositories.ExpenseRepository;
import com.binhcodev.spring_boot_expense_tracker.repositories.UserRepository;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense create(ExpenseDto expenseDto) {
        String currentEmail = userService.getCurrentUserEmail();
        Optional<User> currentUser = userRepository.findByEmail(currentEmail);
        List<Category> categories = categoryRepository.findAllById(expenseDto.getCategories());
        if(currentUser.isPresent()){
            Expense expense = Expense
            .builder()
            .description(expenseDto.getDescription())
            .categories(categories)
            .user(currentUser.get())
            .build();
            return expenseRepository.save(expense);
        }
      return null;
       
    }

}
