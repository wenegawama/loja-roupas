package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<Contact> insert(@RequestBody @Valid CreateUserDTO createUserDTO) {
        var userContactCreated = userService.create(createUserDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userContactCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(userContactCreated);
    }
}
