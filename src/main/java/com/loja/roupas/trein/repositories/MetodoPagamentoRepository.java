package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.payment.MetodoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoPagamentoRepository extends JpaRepository<MetodoPagamento, Long> {

}

