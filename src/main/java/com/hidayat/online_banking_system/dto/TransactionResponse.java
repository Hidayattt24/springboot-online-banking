package com.hidayat.online_banking_system.dto;

import com.hidayat.online_banking_system.entity.TransactionStatus;
import com.hidayat.online_banking_system.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TransactionResponse {
    private Long transactionId;
    private TransactionType type;
    private BigDecimal amount;
    private String sourceAccountNumber;
    private String targetAccountNumber;
    private TransactionStatus status;
    private String description;
    private LocalDateTime timestamp;
}