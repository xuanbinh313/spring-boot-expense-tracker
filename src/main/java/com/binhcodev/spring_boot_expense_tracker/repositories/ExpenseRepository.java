package com.binhcodev.spring_boot_expense_tracker.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.binhcodev.spring_boot_expense_tracker.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT e FROM Expense e JOIN e.categories c WHERE (:description IS NULL OR e.description LIKE %:description%) AND (:categories IS NULL OR c.id IN :categories) AND (:from IS NULL OR e.createdAt >= :from) AND (:to IS NULL OR e.createdAt <= :to)")
    public List<Expense> findAllByCondition(@Param("description") String description,@Param("categories") List<Long> categories, @Param("from") LocalDate from, @Param("to") LocalDate to);
}
