package com.hidayat.online_banking_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class RegisterUserRequest {

    @NotBlank(message ="Username tidak boleh kosong")
    @Size(min = 3, max = 50, message = "Username minimal 3 karakter")
    private String username;

    @NotBlank (message="Email tidak boleh kosong")
    @Email (message="Format Email tidak valid")
    private String email;
    
    @NotBlank (message="Password tidak boleh kosong")
    @Size(message="Format password tidak valid")
    private String password;

    @NotBlank(message = "Nama tidak boleh kosonh")
    private String fullName;
}
