package com.hidayat.online_banking_system.repository;

import com.hidayat.online_banking_system.entity.Account;
import com.hidayat.online_banking_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySourceAccountOrTargetAccountOrderByCreatedAtDesc(Account source, Account target);
}