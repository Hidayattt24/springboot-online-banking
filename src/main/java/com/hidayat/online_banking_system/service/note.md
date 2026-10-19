Konsep: Mengapa Ada Service?
Service adalah "otak" aplikasi perbankan. Di sinilah semua aturan bisnis dieksekusi:
1. Validasi bisnis: email / username sudah dipakai belum?
2. Simpan user ke database.
3. Otomatis buatkan satu rekening (Account) dengan saldo awal 0.
4. @Transactional: Memastikan pembuatan User dan Account berjalan atomik (jika simpan rekening gagal, simpan user otomatis dibatalkan/rollback).