package com.robert.test.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.robert.test.app.models.Userul;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Userul,Long> {
    @Query("SELECT s FROM Userul s WHERE s.email = ?1")
    Optional<Userul> findUserByEmail(String email);
}
