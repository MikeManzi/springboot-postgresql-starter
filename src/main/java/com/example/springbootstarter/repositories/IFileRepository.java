package com.example.springbootstarter.repositories;

import com.example.springbootstarter.fileHandling.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IFileRepository extends JpaRepository<File, UUID> {
}
