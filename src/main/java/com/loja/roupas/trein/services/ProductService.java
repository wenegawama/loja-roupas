package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.product.CreateProductDTO;
import com.loja.roupas.trein.domain.entities.product.Product;
import com.loja.roupas.trein.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(CreateProductDTO createProductDTO) {
        Product  product = new Product();
        product.setName(createProductDTO.name());
        product.setDescription(createProductDTO.description());
        product.setCategory(createProductDTO.category());
        product.setPrice(createProductDTO.price());
        product.setColor(createProductDTO.color());
        product.setQuantity(createProductDTO.quantity());
        product.setTamanho(createProductDTO.tamanho());

        log.info("Salvando o produto....");
        return productRepository.save(product);
    }
}
