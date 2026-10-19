package com.hidayat.online_banking_system.controller;

import com.hidayat.online_banking_system.dto.RegisterUserRequest;
import com.hidayat.online_banking_system.entity.Account;
import com.hidayat.online_banking_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserRequest request) {
        try {
            Account account = userService.registerUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(account);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

// Penjelasan Anotasi:
// * @RestController: Class ini handler endpoint HTTP REST yang mereturn JSON langsung.
// * @RequestMapping("/api/users"): Prefix path URL untuk semua method di controller ini.
// * @PostMapping("/register"): Tangkap request POST /api/users/register.
// * @Valid: Memeriksa aturan validasi di DTO (@NotBlank, @Email).
// * @RequestBody: Deserialize body JSON dari client ke objek Java RegisterUserRequest.