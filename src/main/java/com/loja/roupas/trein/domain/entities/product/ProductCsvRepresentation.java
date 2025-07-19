package com.loja.roupas.trein.domain.entities.product;

import com.loja.roupas.trein.domain.entities.enums.Category;
import com.loja.roupas.trein.domain.entities.enums.Tamanho;
import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCsvRepresentation {

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "description")
    private String description;

    @CsvBindByName(column = "category")
    private Category category;

    @CsvBindByName(column = "price")
    private Double price;

    @CsvBindByName(column = "color")
    private String color;

    @CsvBindByName(column = "quantity")
    private Integer quantity;

    @CsvBindByName(column = "tamanho")
    private Tamanho tamanho;

//    @CsvBindByName(column = "foto")
//    private byte[] foto;
}
