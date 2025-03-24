package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.product.CreateProductDTO;
import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UpdateRecoveryDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UserUpdated;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.product.Product;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.services.AuthenticationService;
import com.loja.roupas.trein.services.ProductService;
import com.loja.roupas.trein.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody @Valid CreateUserDTO createUserDTO) {
        var userContactCreated = userService.create(createUserDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userContactCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(userContactCreated);
    }
    @PostMapping("/product")
    public ResponseEntity<Product> insertProduct(@RequestBody @Valid CreateProductDTO createProductDTO) {
        var productCreated = productService.create(createProductDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/v1/users/product/{id}")
                .buildAndExpand(productCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(productCreated);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserUpdated> update(@RequestBody @Valid UpdateRecoveryDTO updateRecoveryDTO) {
        var updatedUser = authenticationService.updatePassword(updateRecoveryDTO.id(), updateRecoveryDTO);

        return ResponseEntity.ok().body(updatedUser);
    }
}
