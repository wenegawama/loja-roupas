package com.loja.roupas.trein.domain.dto.contactDTO;

public record DetailContactDTO(
        Long id,
        String name,
        String documento,
        String address,
        String zipcode,
        String city,
        String complement,
        String reference_place
) {
}
