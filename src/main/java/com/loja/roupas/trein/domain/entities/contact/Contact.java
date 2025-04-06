package com.loja.roupas.trein.domain.entities.contact;

import com.loja.roupas.trein.domain.entities.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "contact")
@Table(name = "TBL_WENSHOP_CONTACT")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact implements Serializable {

    @Id
    @SequenceGenerator(
            name="seq_contact",
            sequenceName="SEQ_TBL_WENSHOP_CONTACT",
            schema = "SQLUTIL_OWNER",
            allocationSize=1)
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="seq_contact")
    private Long id;

    @Column(name="name",unique=false,nullable=false)
    private String name;

    @Column(name="documento",nullable=false)
    private String documento;

    @Column(name="zipcode",unique=false,nullable=false)
    private String zipcode;

    @Column(name="city",unique=false,nullable=false)
    private String city;

    @Column(name="neighborhood",unique=false,nullable=false)
    private String neighborhood;

    @Column(name="street",unique=false,nullable=false)
    private String street;

    @Column(name="numero",unique=false,nullable=false)
    private String numero;

    @Column(name="complement",unique=false,nullable=false)
    private String complement;

    @Column(name="phone",unique=false,nullable=false)
    private String phone;

    @Column(name="referencePlace",unique=false,nullable=false)
    private String referencePlace;

    @Column(name="pergunta",unique=false,nullable=false)
    private String pergunta;

    @Column(name="resposta_pergunta",unique=false,nullable=false)
    private String respostaPergunta;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
