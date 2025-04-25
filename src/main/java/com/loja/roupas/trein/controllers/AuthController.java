package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.auth.AuthenticationDTO;
import com.loja.roupas.trein.domain.dto.contactDTO.RecoveryContactDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import com.loja.roupas.trein.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Autenticação", description = "Recurso de login e recuperação da senha")
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

    @Operation(summary = "Realizar o login",
            description = "É necessário um email e uma senha válidos." +
                    "O email deve conter '@', um ponto e ser seguido por exatamente 3 caracteres." +
                    "A senha deve ter pelo menos 8 caracteres, incluindo uma letra maiúscula, um número e um símbolo.")
    @PostMapping("/login")
    public ResponseEntity<Contact> login(@RequestBody @Valid AuthenticationDTO data) {
        var contact = authenticationService.doLogin(data);

        return ResponseEntity.ok(contact);

    }

    @Operation(summary = "Recuperação da senha esquecida",
            description = "É necessário informar o documento, o email, a pergunta secreta  e a resposta secreta válidos." +
                    "O documento deve ter 11 digitos no caso do  CPF e 14 digitos no caso do CNPJ" +
                    "O email deve conter '@', um ponto e ser seguido por exatamente 3 caracteres." +
                    "A pergunta secreta deve ser aquela escolida no momento do cadastro" +
                    "A resposta secreta deve ser aquela informada no momento do cadastro"
    )
    @PostMapping("/recovery")
    public ResponseEntity<Contact> isRecoverPassword(@RequestBody RecoveryContactDTO recoveryContactDTO) {
        var recoveryUser = authenticationService.isRecovery(recoveryContactDTO);
        return ResponseEntity.ok().body(recoveryUser);
    }

}
