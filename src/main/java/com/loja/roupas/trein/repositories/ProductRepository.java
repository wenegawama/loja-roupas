package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
