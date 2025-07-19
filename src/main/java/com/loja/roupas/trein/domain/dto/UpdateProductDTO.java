package com.loja.roupas.trein.domain.dto;

import com.loja.roupas.trein.domain.entities.enums.Category;
import com.loja.roupas.trein.domain.entities.enums.Tamanho;
import jakarta.validation.constraints.NotNull;

public record UpdateProductDTO(
        @NotNull
        Long id,
        String name,
        String description,
        Category category,
        Double price,
        String color,
        Integer quantity,
        Tamanho tamanho,
        byte[] foto
) {
}
