package com.loja.roupas.trein.domain.dto.contactDTO;

public record RecoveryContactDTO(

        String documento,
        String email,
        String pergunta,

        String respostaPergunta
) {
}
