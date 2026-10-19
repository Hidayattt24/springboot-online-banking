package com.hidayat.online_banking_system.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.hidayat.online_banking_system.dto.RegisterUserRequest;
import com.hidayat.online_banking_system.entity.Account;
import com.hidayat.online_banking_system.entity.User;
import com.hidayat.online_banking_system.repository.AccountRepository;
import com.hidayat.online_banking_system.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Service 
@RequiredArgsConstructor 
public class UserService {
// final bukan berarti karena mengambil class lain. 
// final berarti setelah objek repository diberikan, referensinya tidak boleh diganti 
// dengan objek repository lain.
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    @Transactional
    public Account registerUser(RegisterUserRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username sudah terdaftar!");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email sudah terdaftar!");
        }
        // 1. Buat User
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        User savedUser = userRepository.save(user);
        // 2. Buat Rekening otomatis untuk User
        Account account = new Account();
        account.setUser(savedUser);
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(BigDecimal.ZERO);
        return accountRepository.save(account);
    }
    private String generateAccountNumber() {
        Random random = new Random();
        String accountNumber;
        do {
            long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);
            accountNumber = String.valueOf(number);
        } while (accountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }
}

// Penjelasan:
// * @RequiredArgsConstructor: Anotasi Lombok untuk membuat constructor bagi field final. 
// Spring Boot otomatis melakukan Constructor Dependency Injection (memasukkan instance UserRepository dan AccountRepository).