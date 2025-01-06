package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
