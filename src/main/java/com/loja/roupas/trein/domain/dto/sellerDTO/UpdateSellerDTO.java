package com.loja.roupas.trein.domain.dto.sellerDTO;

import com.loja.roupas.trein.domain.entities.seller.Seller;
import jakarta.validation.constraints.NotNull;

public record UpdateSellerDTO(

        @NotNull
        Long id,
        String name,
        String surname,
        String cnpj,
        String fone,
        String email
) {
        public UpdateSellerDTO(Seller seller) {
                this(seller.getId(), seller.getName(), seller.getSurname(), seller.getCnpj(), seller.getFone(), seller.getEmail());
        }
}
