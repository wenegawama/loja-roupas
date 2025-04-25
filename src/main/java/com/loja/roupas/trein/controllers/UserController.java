package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.product.CreateProductDTO;
import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UpdateRecoveryDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.product.Product;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.services.AuthenticationService;
import com.loja.roupas.trein.services.ProductService;
import com.loja.roupas.trein.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@Tag(name = "Usuario")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(summary = "Cadastrar consumidor/administrador.")
    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody @Valid CreateUserDTO createUserDTO) {
        var userContactCreated = userService.create(createUserDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userContactCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(userContactCreated);
    }
    @Operation(summary = "Cadastrar um produto.")
    @PostMapping("/product")
    public ResponseEntity<Product> insertProduct(@RequestBody @Valid CreateProductDTO createProductDTO) throws IOException {
        var productCreated = productService.create(createProductDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/v1/users/product/{id}")
                .buildAndExpand(productCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(productCreated);
    }

    @Operation(summary = "Alterar a senha.")
    @PatchMapping("/updatePassword")
    public ResponseEntity<User> update(@RequestBody @Valid UpdateRecoveryDTO updateRecoveryDTO) {
        User updatedUser = authenticationService.updatePassword(updateRecoveryDTO);

        return ResponseEntity.ok().body(updatedUser);
    }
}
