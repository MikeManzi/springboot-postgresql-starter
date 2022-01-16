package com.example.springbootstarter.repositories;

import com.example.springbootstarter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID userID);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailOrMobile(String email, String mobile);

    boolean existsByEmail(String email);
    boolean existsByMobile(String mobile);
}
