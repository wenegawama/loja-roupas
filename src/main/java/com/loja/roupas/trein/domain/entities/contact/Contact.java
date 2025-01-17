package com.loja.roupas.trein.domain.entities.contact;

import com.loja.roupas.trein.domain.dto.contactDTO.CreateContactDTO;
import com.loja.roupas.trein.domain.dto.login.CreateLoginDTO;
import com.loja.roupas.trein.domain.entities.user.User;
import jakarta.persistence.*;
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

    @Column(name="documento",unique=true,nullable=false)
    private String documento;

    private String address;
    private String zipcode;
    private String city;
    private String complement;
    private String phone;
    private String reference_place;
    private String pergunta;
    private String resposta_pergunta;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;


}
