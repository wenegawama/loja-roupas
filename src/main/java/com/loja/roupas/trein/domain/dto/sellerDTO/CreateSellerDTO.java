package com.loja.roupas.trein.domain.dto.sellerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CNPJ;

public record CreateSellerDTO(
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotBlank
        @CNPJ
        String cnpj,
        @NotBlank
        String fone,

        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
        String email
) {
}
