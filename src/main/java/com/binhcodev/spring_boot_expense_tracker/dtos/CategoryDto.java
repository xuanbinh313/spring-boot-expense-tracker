package com.binhcodev.spring_boot_expense_tracker.dtos;

import com.github.slugify.Slugify;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class CategoryDto {
    private String slug;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;
   final Slugify slg = Slugify.builder().build();

    public CategoryDto(String slug, String name, String description) {
        if(slug == null) {
            this.slug = slg.slugify(name);
        } else {
            this.slug = slug;
        }
        this.slug = slug;
        this.name = name;
        this.description = description;
    }
}
