package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.product.CreateProductDTO;
import com.loja.roupas.trein.domain.entities.product.Product;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.ProductRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    public Product create(CreateProductDTO createProductDTO) throws IOException {
        User user = new User();
        user.setId(createProductDTO.id_user());



        Product product = new Product();
        product.setName(createProductDTO.name());
        product.setDescription(createProductDTO.description());
        product.setCategory(createProductDTO.category());
        product.setPrice(createProductDTO.price());
        product.setColor(createProductDTO.color());
        product.setQuantity(createProductDTO.quantity());
        product.setTamanho(createProductDTO.tamanho());
        product.setFoto(createProductDTO.foto().getBytes());

        product.setUser(user);

        log.info("Salvando o produto....");
        return productRepository.save(product);
    }
}
