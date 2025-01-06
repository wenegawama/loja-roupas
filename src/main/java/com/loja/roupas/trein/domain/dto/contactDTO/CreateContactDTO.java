package com.loja.roupas.trein.domain.dto.contactDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateContactDTO(
        @NotBlank(message = "É obligatório informar o nome")
        @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
        String name,
        @NotBlank(message = "É obligatório informar o documento")
        @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
        String documento,
        @NotBlank(message = "É obligatório informar o endereço")
        @Size(max = 255, message = "Deve ter no maximo {500} caracteres")
        String address,
        @NotBlank(message = "É obligatório informar o Cep")
        @Size(max = 8, message = "Deve ter no maximo {8} caracteres")
        String zipcode,
        @NotBlank(message = "É obligatório informar a cidade")
        @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
        String city,
        @NotBlank(message = "É obligatório informar o complemento")
        @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
        String complement,
        @NotBlank(message = "É obligatório informar o telefone")
        @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
        String phone,
        @NotBlank(message = "É obligatório informar o ponto de referência")
        @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
        String reference_place
) {
}
