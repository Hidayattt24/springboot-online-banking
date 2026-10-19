package com.hidayat.online_banking_system.service;

import com.hidayat.online_banking_system.dto.DepositRequest;
import com.hidayat.online_banking_system.dto.TransactionResponse;
import com.hidayat.online_banking_system.dto.TransferRequest;
import com.hidayat.online_banking_system.entity.*;
import com.hidayat.online_banking_system.repository.AccountRepository;
import com.hidayat.online_banking_system.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    @Transactional
    public TransactionResponse deposit(DepositRequest request) {
        Account account = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Rekening tidak ditemukan!"));
        // Tambah saldo
        account.setBalance(account.getBalance().add(request.getAmount()));
        accountRepository.save(account);
        // Catat riwayat transaksi
        Transaction transaction = new Transaction();
        transaction.setTargetAccount(account);
        transaction.setAmount(request.getAmount());
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setDescription(request.getDescription());
        Transaction saved = transactionRepository.save(transaction);
        return mapToResponse(saved);
    }
    @Transactional
    public TransactionResponse transfer(TransferRequest request) {
        if (request.getSourceAccountNumber().equals(request.getTargetAccountNumber())) {
            throw new RuntimeException("Rekening asal dan tujuan tidak boleh sama!");
        }
        Account sourceAccount = accountRepository.findByAccountNumber(request.getSourceAccountNumber())
                .orElseThrow(() -> new RuntimeException("Rekening pengirim tidak ditemukan!"));
        Account targetAccount = accountRepository.findByAccountNumber(request.getTargetAccountNumber())
                .orElseThrow(() -> new RuntimeException("Rekening penerima tidak ditemukan!"));
        // Validasi kecukupan saldo
        if (sourceAccount.getBalance().compareTo(request.getAmount()) < 0) {
            throw new RuntimeException("Saldo rekening pengirim tidak mencukupi!");
        }
        // Potong saldo pengirim & tambah saldo penerima
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(request.getAmount()));
        targetAccount.setBalance(targetAccount.getBalance().add(request.getAmount()));
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
        // Catat jurnal transfer
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);
        transaction.setAmount(request.getAmount());
        transaction.setType(TransactionType.TRANSFER);
        transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setDescription(request.getDescription());
        Transaction saved = transactionRepository.save(transaction);
        return mapToResponse(saved);
    }
    private TransactionResponse mapToResponse(Transaction t) {
        return new TransactionResponse(
                t.getId(),
                t.getType(),
                t.getAmount(),
                t.getSourceAccount() != null ? t.getSourceAccount().getAccountNumber() : null,
                t.getTargetAccount().getAccountNumber(),
                t.getStatus(),
                t.getDescription(),
                t.getCreatedAt()
        );
    }
}