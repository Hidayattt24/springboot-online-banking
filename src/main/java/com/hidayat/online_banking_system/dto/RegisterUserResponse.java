package com.hidayat.online_banking_system.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor 
public class RegisterUserResponse {
    private Long userId;
    private String username;
    private String email;
    private String fullName;
    private String accountNumber;
    private BigDecimal balance;
}
