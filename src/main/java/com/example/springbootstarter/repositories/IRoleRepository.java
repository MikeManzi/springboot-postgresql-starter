package com.example.springbootstarter.repositories;

import com.example.springbootstarter.enums.ERole;
import com.example.springbootstarter.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IRoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(ERole role);
}
