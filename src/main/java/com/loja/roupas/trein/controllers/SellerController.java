package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.product.CreateProductDTO;
import com.loja.roupas.trein.domain.dto.sellerDTO.CreateSellerDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UpdateRecoveryDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.product.Product;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.services.AuthenticationService;
import com.loja.roupas.trein.services.ProductService;
import com.loja.roupas.trein.services.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/users/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody @Valid CreateSellerDTO createSellerDTO) {
        var sellerContactCreated = sellerService.create(createSellerDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sellerContactCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(sellerContactCreated);
    }
    @PostMapping("/product")
    public ResponseEntity<Product> insertProduct(@RequestBody @Valid CreateProductDTO createProductDTO) throws IOException {
        var productCreated = productService.create(createProductDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/v1/users/product/{id}")
                .buildAndExpand(productCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(productCreated);
    }

    @PatchMapping("/updatePassword")
    public ResponseEntity<User> update(@RequestBody @Valid UpdateRecoveryDTO updateRecoveryDTO) {
        User updatedUser = authenticationService.updatePassword(updateRecoveryDTO);

        return ResponseEntity.ok().body(updatedUser);
    }
}
