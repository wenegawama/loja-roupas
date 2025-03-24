package com.loja.roupas.trein.domain.dto.sellerDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

    public record CreateSellerDTO(
       @Email(message = "É obligatório informar o email!")
      @NotBlank(message = "Deve preecher o campo email")
      @Pattern(
              regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
              message = "O email deve conter '@', um ponto e ser seguido por exatamente 3 caracteres."
      )
      String email,

      @NotBlank(message = "É obligatório informar a senha")
      @Pattern(
              regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
              message = "A senha deve ter pelo menos 8 caracteres, incluindo uma letra maiúscula, um número e um símbolo.")
      String password,
      @NotBlank(message = "É obligatório informar o nome completo")
      @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
      String name,
      @NotBlank(message = "É obligatório informar o documento")
      @Pattern(regexp = "^\\d{14}$", message = "O documento deve conter 14 digitos!")
      String documento,
      @NotBlank(message = "É obligatório informar o endereço")
      @Size(max = 255, message = "Deve ter no maximo {500} caracteres")
      @Pattern(
              regexp = "^[a-zA-Z]{2,}(?:\\s+[a-zA-Z]{2,})*,\\s*\\d+$",
              message = "O campo Endereço deve conter pelo menos duas palavras, uma vírgula e um número."
      )
      String address,
      @NotBlank(message = "É obligatório informar o Cep")
      @Pattern(regexp = "^\\d{8}$", message = "O Cep deve conter 8 digitos!")
      String zipcode,
      @NotBlank(message = "É obligatório informar a cidade")
      @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
      @Pattern(
              regexp = "^[a-zA-ZÀ-ÿ]+(?:\\s[a-zA-ZÀ-ÿ]+)*(?:,\\s*[a-zA-ZÀ-ÿ]+(?:\\s[a-zA-ZÀ-ÿ]+)*)*$",
              message = "A cidade deve conter uma ou mais palavras separadas por vírgulas, sem números ou caracteres especiais."
      )
      String city,
      String complement,
      @NotBlank(message = "É obligatório informar o telefone")
      @Pattern(regexp = "^\\d{11}$", message = "O telefone deve conter 11 digitos!")
      String phone,
      String reference_place,
    //        @NotBlank(message = "É obligatório informar a resposta")
    //        @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
      String pergunta,
      @NotBlank(message = "É obligatório informar a resposta")
      @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
      String resposta_pergunta,
      String perfil
) {
}