package com.bank.service;

import com.bank.dto.TransferRequestDTO;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class TransferService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public void processTransfer(TransferRequestDTO request) {

        // 1. Fetch accounts
        Account from = accountRepository.findById(request.getFromAccountId())
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        Account to = accountRepository.findById(request.getToAccountId())
                .orElseThrow(() -> new RuntimeException("Destination account not found"));

        // 2. Validate
        if (from.getId().equals(to.getId()))
            throw new RuntimeException("Cannot transfer to the same account");

        if (from.getBalance().compareTo(request.getAmount()) < 0)
            throw new RuntimeException("Insufficient balance");

        // 3. Debit & Credit
        from.setBalance(from.getBalance().subtract(request.getAmount()));
        to.setBalance(to.getBalance().add(request.getAmount()));
        accountRepository.save(from);
        accountRepository.save(to);

        // 4. Record transaction
        Transaction tx = new Transaction();
        tx.setFromAccount(from);
        tx.setToAccount(to);
        tx.setAmount(request.getAmount());
        tx.setType("TRANSFER");
        tx.setDescription(request.getDescription());
        tx.setStatus("SUCCESS");
        tx.setCreatedAt(LocalDateTime.now());
        transactionRepository.save(tx);
    }
}