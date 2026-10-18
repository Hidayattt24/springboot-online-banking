package com.hidayat.online_banking_system.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity 
@Table(name = "users")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 

// * @Entity: Menandai class ini sebagai tabel database.
// * @Table(name = "users"): Menentukan nama tabel di database (kata user sering jadi kata terlarang/reserved keyword di SQL).
// * @Id: Primary key.
// * @GeneratedValue(strategy = GenerationType.IDENTITY): Auto-increment ID (1, 2, 3, ...).
// * @Column: Konfigurasi kolom (contoh: unique = true, nullable = false).
// * @Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor: Anotasi Lombok agar tidak perlu ketik manual getter/setter dan constructor.

public class User {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(name = "full_name", unique = true)
    private String fullName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    //Catatan @PrePersist: Otomatis mengisi kolom created_at dengan waktu saat ini sesaat sebelum data disimpan ke database.

    @PrePersist 
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
