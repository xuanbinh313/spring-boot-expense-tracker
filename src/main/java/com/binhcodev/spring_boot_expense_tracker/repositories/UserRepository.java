package com.binhcodev.spring_boot_expense_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binhcodev.spring_boot_expense_tracker.entities.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
