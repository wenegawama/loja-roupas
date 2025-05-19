package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.payment.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Cartao, Long> {

}
