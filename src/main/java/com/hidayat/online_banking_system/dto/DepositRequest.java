package com.hidayat.online_banking_system.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class DepositRequest {
    @NotBlank(message = "Nomor rekening tidak boleh kosong")
    private String accountNumber;
    @NotNull(message = "Nominal deposit tidak boleh kosong")
    @DecimalMin(value = "1000.00", message = "Minimal deposit Rp 1.000")
    private BigDecimal amount;
    private String description;
}