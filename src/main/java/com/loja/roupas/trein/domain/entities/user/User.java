package com.loja.roupas.trein.domain.entities.user;

import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "user")
@Table(name = "TBL_WENSHOP_USER")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {


    @Id
    @SequenceGenerator(
            name="seq_user",
            sequenceName="SEQ_TBL_WENSHOP_USER",
            schema = "SQLUTIL_OWNER",
            initialValue=6,
            allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_user")
    @Column(name="id",unique=true,nullable=false)
    private Long id;

    private String email;
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;


    //coluna da pergunta
    public User(CreateUserDTO createUserDTO) {
        this.email = createUserDTO.email();
        this.password = createUserDTO.password();
    }
}
