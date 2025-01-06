package com.loja.roupas.trein.domain.entities.contact;

import com.loja.roupas.trein.domain.dto.contactDTO.CreateContactDTO;
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
            initialValue=9,
            allocationSize=1)
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="seq_contact")
    private Long id;

    private String name;
    private String documento;
    private String address;
    private String zipcode;
    private String city;
    private String complement;
    private String phone;
    private String reference_place;

    @OneToOne
    @MapsId
    private User user;

    public Contact(CreateContactDTO createContactDTO) {
        this.name = createContactDTO.name();
        this.documento = createContactDTO.documento();
        this.address = createContactDTO.address();
        this.zipcode = createContactDTO.zipcode();
        this.city = createContactDTO.city();
        this.complement = createContactDTO.complement();
        this.phone = createContactDTO.phone();
        this.reference_place = createContactDTO.reference_place();
    }
}
