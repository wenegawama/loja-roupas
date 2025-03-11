package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/recovery")
public class RecoveryController {

    @Autowired
    private AuthenticationService loginService;

//    @PostMapping
//    public ResponseEntity<User> recoveryPassword(@RequestBody CreateUserDTO createUserDTO) {
//        var user = loginService.isRecoverPassword(createUserDTO);
//        return ResponseEntity.ok(user);
//    }
//
//    @PutMapping
//    public ResponseEntity<Contact> create(@RequestBody CreateUserDTO createUserDTO) {
//        var userContactCreated = loginService.isRecoverPassword(createUserDTO);
//
//        return ResponseEntity.ok().body(userContactCreated);
//    }

}
