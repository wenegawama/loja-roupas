package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.repositories.UserRepository;
import com.loja.roupas.trein.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody CreateUserDTO createUserDTO) {
        var userCreated = userService.create(createUserDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(userCreated);
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        var createdUserList = userService.listAll();
        return ResponseEntity.ok(createdUserList);
    }
}
