package com.loja.roupas.trein.domain.dto.userDTO;

import com.loja.roupas.trein.domain.entities.perfil.Perfil;
import com.loja.roupas.trein.domain.entities.user.User;
import jakarta.validation.constraints.NotNull;

public record UserUpdated(
        @NotNull
        Long id,
        String email,
        String password,
        Perfil perfil

) {

    public UserUpdated(User user) {
        this(user.getId(), user.getEmail(), user.getPassword(),user.getPerfil());
    }
}
