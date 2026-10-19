package com.hidayat.online_banking_system.repository;

import com.hidayat.online_banking_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}

// Penjelasan:
// * @Repository: Penanda bean komponen akses database untuk Spring Container.
// * existsBy...: Dipakai untuk validasi agar tidak ada username/email ganda saat registrasi.