package com.bank.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AccountDTO {

    private Long id;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private String currency;
}
