package com.loja.roupas.trein.domain.entities.user;

import com.loja.roupas.trein.domain.dto.login.CreateLoginDTO;
import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.entities.perfil.Perfil;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
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
            allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_user")
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "email", updatable = false, nullable = false)
    private String email;

    @Column(name = "password", updatable = false, nullable = false)
    private String password;


    @OneToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    public User(CreateLoginDTO createLoginDTO) {
        this.email= createLoginDTO.email();
        this.password = createLoginDTO.password();
    }

    public User(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }


//coluna da pergunta

}
