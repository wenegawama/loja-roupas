package com.loja.roupas.trein.controllers;

import com.loja.roupas.trein.domain.dto.CreateCardDTO;
import com.loja.roupas.trein.domain.dto.MetodoPagamentoDTO;
import com.loja.roupas.trein.domain.entities.payment.Cartao;
import com.loja.roupas.trein.domain.entities.payment.MetodoPagamento;
import com.loja.roupas.trein.services.CardService;
import com.loja.roupas.trein.services.MetodoPagamentoService;
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
@RequestMapping("/api/v1/payment")
public class PaymentMethodController {

    @Autowired
    private MetodoPagamentoService metodoPagamentoService;

    @PostMapping
    public ResponseEntity<MetodoPagamento> create(@RequestBody MetodoPagamentoDTO dto) {
        log.info("Entrando no methodo de pagamento do cartão");

        var PaymentMethodCreated = metodoPagamentoService.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(PaymentMethodCreated.getId()).toUri();

        log.info("Retornando os dados do metodo de pagamento  no controller");
        return ResponseEntity.created(uri).body(PaymentMethodCreated);
    }
}
