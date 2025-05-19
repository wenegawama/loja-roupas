package com.loja.roupas.trein.domain.entities.payment;

import com.loja.roupas.trein.domain.entities.contact.Contact;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "TBL_WENSHOP_METHOD_PAYMENT")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MetodoPagamento {

    @Id
    @SequenceGenerator(
            name="seq_methodpayment",
            sequenceName="SEQ_TBL_WENSHOP_METHOD_PAYMENT",
            schema = "SQLUTIL_OWNER",
            allocationSize=1)
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator="seq_methodpayment")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "payment_method", nullable = false)
    private String metodoPagamento;

    @ManyToOne
    @JoinColumn(name = "id_contact")
    private Contact contact;

    //status
}
