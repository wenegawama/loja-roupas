package com.loja.roupas.trein.domain.dto.perfilDTO;

import jakarta.validation.constraints.NotBlank;

public record CreatePerfilDTO(
        @NotBlank
        String name
) {
}
