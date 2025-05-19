package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM user u WHERE u.email = ?1 AND u.password = ?2")
    User findByEmailAndPassword(String email, String password);

    @Query("SELECT u FROM user u WHERE u.email = ?1")
    User findByEmail(String email);
}

