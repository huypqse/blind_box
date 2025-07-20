package com.example.Blind_Box.repository;

import com.example.Blind_Box.entity.SystemAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<SystemAccounts, Long> {
    Optional<SystemAccounts> findByEmail(String email);
}
