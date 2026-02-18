package com.bank.service;

import com.bank.dto.AccountDTO;
import com.bank.dto.TransactionDTO;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public List<AccountDTO> getAccountsByUser(Long userId) {
        return accountRepository.findByUserId(userId)
                .stream()
                .map(this::toAccountDTO)
                .collect(Collectors.toList());
    }

    public List<TransactionDTO> getRecentTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId)
                .stream()
                .map(this::toTransactionDTO)
                .collect(Collectors.toList());
    }

    // --- Mappers ---
    private AccountDTO toAccountDTO(Account a) {
        AccountDTO dto = new AccountDTO();
        dto.setId(a.getId());
        dto.setAccountNumber(a.getAccountNumber());
        dto.setAccountType(a.getAccountType());
        dto.setBalance(a.getBalance());
        dto.setCurrency(a.getCurrency());
        return dto;
    }

    private TransactionDTO toTransactionDTO(Transaction t) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(t.getId());
        dto.setType(t.getType());
        dto.setDescription(t.getDescription());
        dto.setAmount(t.getAmount());
        dto.setStatus(t.getStatus());
        dto.setCreatedAt(t.getCreatedAt());
        if (t.getFromAccount() != null)
            dto.setFromAccountNumber(t.getFromAccount().getAccountNumber());
        if (t.getToAccount() != null)
            dto.setToAccountNumber(t.getToAccount().getAccountNumber());
        return dto;
    }
}