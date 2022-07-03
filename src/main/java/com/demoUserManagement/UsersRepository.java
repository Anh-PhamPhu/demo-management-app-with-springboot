package com.demoUserManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM users u WHERE u.email = ?1")
    Users findByEmail(String email);
}
