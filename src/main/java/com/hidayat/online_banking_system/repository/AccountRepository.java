package com.hidayat.online_banking_system.repository;

import com.hidayat.online_banking_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);
    boolean existsByAccountNumber(String accountNumber);
}

// Penjelasan:
// * findByAccountNumber: Dipakai untuk cari rekening tujuan transfer atau cek saldo.