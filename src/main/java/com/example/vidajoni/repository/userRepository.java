package com.example.vidajoni.repository;

import com.example.vidajoni.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository <user, Integer> {
}
