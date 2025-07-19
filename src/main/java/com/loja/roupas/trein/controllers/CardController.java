package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.CreateCardDTO;
import com.loja.roupas.trein.domain.entities.payment.Cartao;
import com.loja.roupas.trein.services.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/v1/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping(value = "/create")
    public ResponseEntity<Cartao> create(@RequestBody  CreateCardDTO dto) {
        log.info("Entrando no controller do cartão");

        var cardCreated = cardService.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cardCreated.getId()).toUri();

        log.info("Retornando os dados do cartão no controller");
        return ResponseEntity.created(uri).body(cardCreated);
    }
}
