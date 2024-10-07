package com.binhcodev.spring_boot_expense_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binhcodev.spring_boot_expense_tracker.entities.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}
