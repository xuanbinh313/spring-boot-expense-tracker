package com.binhcodev.spring_boot_expense_tracker.dtos;

import org.hibernate.validator.constraints.Range;

import com.github.slugify.Slugify;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@ToString
public class ExpenseDto {

    @NotBlank(message = "Description is required")
    private String description;

    private Iterable<Long> categories;

    private Float amount;

    final Slugify slg = Slugify.builder().build();

    public ExpenseDto(String description, Iterable<Long> categories, Float amount) {
        this.description = description;
        this.categories = categories;
        this.amount = amount;
    }
}
