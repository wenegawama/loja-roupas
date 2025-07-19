package com.loja.roupas.trein.domain.dto.product;

import com.loja.roupas.trein.domain.entities.enums.Category;
import com.loja.roupas.trein.domain.entities.enums.Tamanho;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCsvDTO(

        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        Category category,
        @NotNull
        Double price,
        @NotBlank
        String color,
        @NotNull
        Integer quantity,
        @NotNull
        Tamanho tamanho,

        byte[] foto,
        @NotNull
        Long id_user
) {
}
