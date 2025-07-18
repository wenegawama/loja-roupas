//package com.loja.roupas.trein.domain.entities.payment;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.SequenceGenerator;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity(name = "payment")
//@Table(name = "TBL_WENSHOP_PAYMENT")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Payment {
//
//    @Id
//    @SequenceGenerator(
//            name="seq_payment",
//            sequenceName="SEQ_TBL_WENSHOP_PAYMENT",
//            schema = "SQLUTIL_OWNER",
//            allocationSize=1)
//    @GeneratedValue(
//            strategy= GenerationType.SEQUENCE,
//            generator="seq_payment")
//    @Column(name = "id", nullable = false, unique = true, updatable = false)
//    private Long id;
//
//    @Column(name = "idOrder", nullable = false)
//    private Long idOrder;
//
//    @Column(name = "idMetodoPagamento", nullable = false)
//    private Long idMetodoPagamento;
//
//    @Column(name = "dataPagamento", nullable = false)
//    private String dataPagamento;
//
//    //Falta implementar os relacionamentos
//
//}
