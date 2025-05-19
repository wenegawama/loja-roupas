package com.loja.roupas.trein.domain.dto;

import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateCardDTO(

        @NotBlank(message = "É obligatório informar o nome do titular do cartão")
        @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
        String nameCard,

        @NotBlank(message = "É obligatório informar o número do cartão")
        @Pattern(regexp = "^\\d{16}$", message = "Deve ter 16 dígitos.")
        Long numberCard,
        @NotBlank(message = "É obligatório informar o mês e ano de validade do cartão")
        String validity,

        @NotBlank(message = "É obligatorio informar o código de segurança do cartão")
        @Pattern(regexp = "^\\d{3}$", message = "Deve ter 3 dígitos.")
        Integer cvc,

        @NotBlank(message = "É obligatório informar o tipo de cartão")
        String typeCard,

        @NotBlank(message = "É obligatório informar o método de cartão")
        String typeMetodoPagamento,

        @NotBlank(message = "É obligatório informar o id do contato! ")
        Contact idContact

) {
}
