//package com.loja.roupas.trein.domain.entities.order;
//
//import com.loja.roupas.trein.domain.entities.enums.OrderStatus;
//import com.loja.roupas.trein.domain.entities.product.Product;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.SequenceGenerator;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity(name = "order")
//@Table(name = "TBL_WENSHOP_ORDER")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Order {
//
//    @Id
//    @SequenceGenerator(
//            name="seq_order",
//            sequenceName="SEQ_TBL_WENSHOP_ORDER",
//            schema = "SQLUTIL_OWNER",
//            allocationSize=1)
//    @GeneratedValue(
//            strategy= GenerationType.SEQUENCE,
//            generator="seq_order")
//    @Column(name = "id", nullable = false, unique = true, updatable = false)
//    private Long id;
//
//    @Column(name = "userId", nullable = false)
//    private Long userId;
//
//    @Column(name = "idPayment", nullable = false)
//    private Long idPayment;
//
//    @Column(name = "orderData", nullable = false)
//    private String orderData;
//
//    @Column(name = "totalOrder", nullable = false)
//    private Double totalOrder;
//
//    @Enumerated(EnumType.STRING)
//    private OrderStatus orderStatus;
//
////    @ManyToMany
////    @JoinTable(
////            name = "tb_order_product",
////            joinColumns = @JoinColumn(name = "order_id"),
////            inverseJoinColumns = @JoinColumn(name = "product_id")
////    )
////    private Set<Product> productSet = new HashSet<>();
//
//
//}
