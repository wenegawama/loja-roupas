//package com.loja.roupas.trein.controllers;
//
//import com.loja.roupas.trein.domain.entities.perfil.Perfil;
//import com.loja.roupas.trein.services.PerfilService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/perfil")
//@Transactional
//public class PerfilController {
//    @Autowired
//    private PerfilService perfilService;
//
////   a criação do perfil somente deve ser feito pelo banco de dados
//    @GetMapping
//    public ResponseEntity<List<Perfil>> list() {
//        var listPerfil = perfilService.listPerfil();
//        return ResponseEntity.ok().body(listPerfil);
//    }
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Perfil> findById(@PathVariable Long id) {
//        var perfilId = perfilService.findById(id);
//        return ResponseEntity.ok().body(perfilId);
//    }
//}
