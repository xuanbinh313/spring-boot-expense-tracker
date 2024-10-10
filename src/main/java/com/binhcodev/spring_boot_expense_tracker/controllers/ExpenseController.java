package com.binhcodev.spring_boot_expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binhcodev.spring_boot_expense_tracker.dtos.ExpenseDto;
import com.binhcodev.spring_boot_expense_tracker.entities.Expense;
import com.binhcodev.spring_boot_expense_tracker.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getAlls() {
        List<Expense> result = expenseService.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody ExpenseDto body) {
        Expense expense = expenseService.create(ExpenseDto.builder()
                .description(body.getDescription())
                .categories(body.getCategories())
                .amount(body.getAmount())
                .build());
        return ResponseEntity.ok(expense);
    }

}
