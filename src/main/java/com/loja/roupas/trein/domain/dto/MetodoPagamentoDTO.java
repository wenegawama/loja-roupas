package com.loja.roupas.trein.domain.dto;

import com.loja.roupas.trein.domain.entities.contact.Contact;

public record MetodoPagamentoDTO(
        String metodoPagamento,
        Contact idContact
) {
}
