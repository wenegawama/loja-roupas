package com.loja.roupas.trein.domain.dto.sellerDTO;

import com.loja.roupas.trein.domain.entities.seller.Seller;

public record DetailSellerDTO(Long id, String name, String surname, String cnpj, String fone, String email) {
    public DetailSellerDTO(Seller seller) {
        this(seller.getId(), seller.getName(), seller.getSurname(), seller.getCnpj(), seller.getFone(), seller.getEmail());
    }
}
