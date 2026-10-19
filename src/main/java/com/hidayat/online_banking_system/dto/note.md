Konsep: Kenapa Butuh DTO?
Jangan pernah menerima data langsung ke class Entity dari input HTTP:
1. Keamanan: Mencegah mass assignment vulnerability (misal: user iseng kirim field id atau manipulasi data lain).
2. Validasi: Anotasi validasi (@NotBlank, @Email, @Size) ditaruh di DTO agar dicek sebelum menyentuh database.