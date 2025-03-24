package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.auth.AuthenticationDTO;
import com.loja.roupas.trein.domain.dto.contactDTO.RecoveryContactDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import com.loja.roupas.trein.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/login")
    public ResponseEntity<Contact> login(@RequestBody @Valid AuthenticationDTO data) {
        var contact = authenticationService.doLogin(data);

        return ResponseEntity.ok(contact);

    }

    @PostMapping("/recovery")
    public ResponseEntity<Contact> isRecoverPassword(@RequestBody RecoveryContactDTO recoveryContactDTO) {
        var recoveryUser = authenticationService.isRecovery(recoveryContactDTO);
        return ResponseEntity.ok().body(recoveryUser);
    }

}
