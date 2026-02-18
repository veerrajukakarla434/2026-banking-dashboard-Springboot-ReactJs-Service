package com.bank.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long id;
    private String type;
    private String description;
    private BigDecimal amount;
    private String status;
    private LocalDateTime createdAt;
    private String fromAccountNumber;
    private String toAccountNumber;
}