package com.binhcodev.spring_boot_expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binhcodev.spring_boot_expense_tracker.dtos.ExpenseDto;
import com.binhcodev.spring_boot_expense_tracker.dtos.ExpenseParamsDto;
import com.binhcodev.spring_boot_expense_tracker.entities.Expense;
import com.binhcodev.spring_boot_expense_tracker.responses.ExpenseResponse;
import com.binhcodev.spring_boot_expense_tracker.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getAlls(@ModelAttribute ExpenseParamsDto expenseParamsDto) {
        List<Expense> result = expenseService.findAllByCondition(expenseParamsDto);
        List<ExpenseResponse> response = ExpenseResponse.fromEntities(result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ExpenseResponse> createExpense(@Valid @RequestBody ExpenseDto body) {
        Expense expense = expenseService.create(ExpenseDto.builder()
                .description(body.getDescription())
                .categories(body.getCategories())
                .amount(body.getAmount())
                .build());
        ExpenseResponse response = ExpenseResponse.builder()
                .id(expense.getId())
                .description(expense.getDescription())
                .categories(expense.getCategories())
                .amount(expense.getAmount())
                .createdAt(expense.getCreatedAt())
                .build();
        return ResponseEntity.ok(response);
    }

}
