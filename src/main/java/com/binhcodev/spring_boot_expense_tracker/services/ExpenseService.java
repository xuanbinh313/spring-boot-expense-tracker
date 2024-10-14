package com.binhcodev.spring_boot_expense_tracker.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.binhcodev.spring_boot_expense_tracker.dtos.ExpenseDto;
import com.binhcodev.spring_boot_expense_tracker.dtos.ExpenseParamsDto;
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

    public List<Expense> findAllByCondition(ExpenseParamsDto expenseParamsDto) {
        if (expenseParamsDto.getFrom() == null && expenseParamsDto.getTo() == null) {
            return expenseRepository.findAllByWithoutDateRange(
                    expenseParamsDto.getDescription(),
                    expenseParamsDto.getCategories());
        }
        if (expenseParamsDto.getFrom() != null && expenseParamsDto.getTo() == null) {
            return expenseRepository.findAllByDateFrom(
                    expenseParamsDto.getDescription(),
                    expenseParamsDto.getCategories(),
                    expenseParamsDto.getFrom());
        }
        if (expenseParamsDto.getFrom() == null && expenseParamsDto.getTo() != null) {
            return expenseRepository.findAllByDateTo(
                    expenseParamsDto.getDescription(),
                    expenseParamsDto.getCategories(),
                    expenseParamsDto.getTo());
        }
        return expenseRepository.findAllByAllCondition(
                expenseParamsDto.getDescription(),
                expenseParamsDto.getCategories(),
                expenseParamsDto.getFrom(),
                expenseParamsDto.getTo());
    }

    public Expense create(ExpenseDto expenseDto) {
        String currentEmail = userService.getCurrentUserEmail();
        Optional<User> currentUser = userRepository.findByEmail(currentEmail);
        List<Category> categories = categoryRepository.findAllById(expenseDto.getCategories());
        if (currentUser.isPresent()) {
            Expense expense = Expense
                    .builder()
                    .description(expenseDto.getDescription())
                    .categories(categories)
                    .user(currentUser.get())
                    .amount(expenseDto.getAmount())
                    .build();
            return expenseRepository.save(expense);
        }
        return null;

    }

    public Expense findOne(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            return expense.get();
        }
        return null;
    }

    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense update(Long id, ExpenseDto expenseDto) {
        Optional<Expense> expense = expenseRepository.findById(id);
        List<Category> categories = categoryRepository.findAllById(expenseDto.getCategories());
        if (expense.isPresent()) {
            expense.get().setDescription(expenseDto.getDescription());
            expense.get().setCategories(categories);
            expense.get().setAmount(expenseDto.getAmount());
            return expenseRepository.save(expense.get());
        }
        return null;
    }

}
