package com.binhcodev.spring_boot_expense_tracker.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LoginResponse {
    private String token;
    private long expiresIn;

}
