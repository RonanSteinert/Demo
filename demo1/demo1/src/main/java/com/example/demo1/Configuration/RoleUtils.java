package com.example.demo1.Configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class RoleUtils {

    public boolean hasRole(String roleName) {
        // Ottieni l'oggetto Authentication dal contesto di sicurezza
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verifica se l'utente ha il ruolo specificato
        if (authentication != null && authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            return authorities.stream().anyMatch(a -> a.getAuthority().equals(roleName));
        }

        return false;
    }
}

