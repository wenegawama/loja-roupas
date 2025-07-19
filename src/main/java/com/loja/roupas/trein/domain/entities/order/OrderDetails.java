//package com.loja.roupas.trein.domain.entities.order;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity(name = "orderDetails")
//@Table(name = "TBL_WENSHOP_ORDER_DETAILS")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class OrderDetails {
//
//    @Id
//    @SequenceGenerator(
//            name="seq_order_details",
//            sequenceName="SEQ_TBL_WENSHOP_ORDER_DETAILS",
//            schema = "SQLUTIL_OWNER",
//            allocationSize=1)
//    @GeneratedValue(
//            strategy= GenerationType.SEQUENCE,
//            generator="seq_order_details")
//    private Long id;
//
//    @Column(name = "id", nullable = false, unique = false, updatable = false)
//    private Long productId;
//
//    @Column(name = "id", nullable = false, unique = false, updatable = false)
//    private Long orderId;
//
//    @Column(name = "id", nullable = false, unique = false, updatable = false)
//    private Double price;
//
//    @Column(name = "id", nullable = false, unique = false, updatable = false)
//    private Long quantity;
//
////    @ManyToMany
////    @JoinTable(
////            name = "tb_product",
////            joinColumns = @JoinColumn(name = "order_details_id"),
////            inverseJoinColumns = @JoinColumn(name = "product_id")
////    )
////    private Set<Product> productSet = new HashSet<>();
//
//}
