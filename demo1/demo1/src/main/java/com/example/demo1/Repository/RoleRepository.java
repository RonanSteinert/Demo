package com.example.demo1.Repository;

import com.example.demo1.Model.Enum.Ruolo;
import com.example.demo1.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Ruolo name);
}
