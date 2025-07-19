package com.loja.roupas.trein.domain.entities.product;

import com.loja.roupas.trein.domain.dto.product.CreateProductDTO;
import com.loja.roupas.trein.domain.entities.enums.Category;
import com.loja.roupas.trein.domain.entities.enums.Tamanho;
import com.loja.roupas.trein.domain.entities.user.User;
import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Table(name = "TBL_WENSHOP_PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @SequenceGenerator(
            name="seq_product",
            sequenceName="SEQ_TBL_WENSHOP_PRODUCT",
            schema = "SQLUTIL_OWNER",
            allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_product")
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "color", updatable = true, nullable = false)
    private String color;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;

//    @Lob
//    private byte[] foto;

    //Antes de criar o produto, preciso ter criado o usuario- Product tem uma dependencia para User
    //Por isso tá 
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

//    @ManyToMany(mappedBy = "order_details")
//    private Set<OrderDetails> orderDetailsSet = new HashSet<>();

    public Product(CreateProductDTO createProductDTO) {
        this.name = createProductDTO.name();
        this.description = createProductDTO.description();
        this.category = createProductDTO.category();
        this.price = createProductDTO.price();
        this.color = createProductDTO.color();
        this.quantity = createProductDTO.quantity();
        this.tamanho = createProductDTO.tamanho();
    }




    public Product updateProduct(Product product) {
        Product p = new Product();
        p.name = product.getName();
        p.description = product.getDescription();
        p.category = product.getCategory();
        p.price = product.getPrice();
        p.color = product.getColor();
        p.quantity = product.getQuantity();
        p.tamanho = product.getTamanho();
        return p;
    }
}

