package com.hidayat.online_banking_system.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class TransferRequest {
    @NotBlank(message = "Rekening asal tidak boleh kosong")
    private String sourceAccountNumber;
    @NotBlank(message = "Rekening tujuan tidak boleh kosong")
    private String targetAccountNumber;
    @NotNull(message = "Nominal transfer tidak boleh kosong")
    @DecimalMin(value = "1000.00", message = "Minimal transfer Rp 1.000")
    private BigDecimal amount;
    private String description;
}