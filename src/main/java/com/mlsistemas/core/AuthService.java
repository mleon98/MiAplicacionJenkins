package com.mlsistemas.core;

public class AuthService {
    
    public boolean login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Campos obligatorios");
        }
        
        // Simulación de base de datos
        return "admin@mlsistemas.com".equals(username) && "Admin123*".equals(password);
    }
}
