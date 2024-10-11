package com.binhcodev.spring_boot_expense_tracker.responses;

import java.util.List;
import java.util.stream.Collectors;
import com.binhcodev.spring_boot_expense_tracker.entities.Category;
import com.binhcodev.spring_boot_expense_tracker.entities.Expense;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExpenseResponse {
    private Long id;
    private String description;
    private List<Category> categories;
    private Float amount;
    private String createdAt;

    public static List<ExpenseResponse> fromEntities(List<Expense> expenses) {
        return expenses.stream()
                .map(expense -> ExpenseResponse.builder()
                        .id(expense.getId())
                        .description(expense.getDescription())
                        .categories(expense.getCategories())
                        .amount(expense.getAmount())
                        .createdAt(expense.getCreatedAt())
                        .build())
                .collect(Collectors.toList());

    }
}
