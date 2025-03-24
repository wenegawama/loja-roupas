package com.loja.roupas.trein.domain.dto.userDTO;

import com.loja.roupas.trein.domain.entities.perfil.Perfil;
import jakarta.validation.constraints.NotNull;

public record UpdateRecoveryDTO(
        @NotNull
        Long id,
        String password
) {
}
