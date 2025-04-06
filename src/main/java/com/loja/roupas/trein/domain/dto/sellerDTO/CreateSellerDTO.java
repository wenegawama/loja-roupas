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
                    regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$",
                    message = "A senha deve ter pelo menos 8 caracteres, incluindo uma letra maiúscula, um número e um símbolo.")
            String password,

            @NotBlank(message = "É obligatório informar o nome completo")
            @Pattern(
                    regexp ="^([a-zA-Z]{2,}\\s[a-zA-Z]{2,})$",
                    message= ""
            )
            String name,

            @NotBlank(message = "É obligatório informar o documento")
            @Pattern(regexp = "^\\d{14}$", message = "O documento deve conter 14 digitos!")
            String documento,

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

            @NotBlank(message = "É obligatório informar o bairro")
            @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
            @Pattern(
                    regexp = "^[A-Za-zÀ-ú]+(?:\\s[A-Za-zÀ-ú]+)*$",
                    message = "O bairro deve conter uma palavra ou mais."
            )
            String neighborhood,

            @NotBlank(message = "É obligatório informar a rua")
            @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
            @Pattern(
                    regexp = "^[A-Za-zÀ-ú]+(?:\\s[A-Za-zÀ-ú]+)*$",
                    message = "A rua deve conter uma ou mais palavras."
            )
            String street,

            @NotBlank(message = "É obligatório informar o número")
            @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
            @Pattern(
                    regexp = "^\\d{1,10}$",
                    message = "O número deve até 10 digitos"
            )
            String numero,


            String complement,

            @NotBlank(message = "É obligatório informar o telefone")
            @Pattern(regexp = "^\\d{11}$", message = "O telefone deve conter 11 digitos!")
            String phone,

            String referencePlace,

            String pergunta,

            @NotBlank(message = "É obligatório informar a resposta")
            @Size(max = 255, message = "Deve ter no maximo {255} caracteres")
            String respostaPergunta,

            String perfil
) {
}