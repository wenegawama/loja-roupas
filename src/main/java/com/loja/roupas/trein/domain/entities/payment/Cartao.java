package com.loja.roupas.trein.domain.entities.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity(name = "card")
@Table(name = "TBL_WENSHOP_CARD")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cartao  {

    @Id
    @SequenceGenerator(
            name="seq_card",
            sequenceName="SEQ_TBL_WENSHOP_CARD",
            schema = "SQLUTIL_OWNER",
            allocationSize=1)
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator="seq_card")
    @Column(name="idcard", unique=true, nullable=false)
    private Long id;

    @Column(name = "namecard", nullable = false)
    private String nameCard;

    @Column(name = "numbercard", nullable = false)
    private Long numberCard;

    @Column(name = "validity", nullable = false)
    private String validity;

    @Column(name = "cvc", nullable = false)
    private Integer cvc;

    @Column(name = "type_card", nullable = false)
    private String type_card;

    @OneToOne
    @JoinColumn(name = "id_method_payment")
    private MetodoPagamento metodoPagamento;

}
