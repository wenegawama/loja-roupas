package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.perfil.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    @Query("SELECT p FROM perfil p WHERE p.name = ?1")
    Perfil findByName(String name);
}