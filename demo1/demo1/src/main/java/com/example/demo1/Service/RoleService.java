package com.example.demo1.Service;

import com.example.demo1.Model.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleService {
    Optional<Role> findByName(String name);
}
