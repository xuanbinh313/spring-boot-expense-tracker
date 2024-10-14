package com.binhcodev.spring_boot_expense_tracker.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
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
public class ExpenseDto {
    @NotBlank(message = "Description is required")
    private String description;

    @NotEmpty(message = "Categories are required")
    private List<Long> categories;

    @Positive(message = "Amount must be greater than zero")
    private Float amount;
}
