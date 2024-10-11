package com.binhcodev.spring_boot_expense_tracker.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseParamsDto {
    private String description;
    private List<Long> categories;
    private LocalDate from;
    private LocalDate to;
}
