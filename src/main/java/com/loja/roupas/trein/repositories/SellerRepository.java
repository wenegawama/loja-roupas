package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    public List<Seller> findAllByActiveTrue();
}
