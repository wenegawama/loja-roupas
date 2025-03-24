package com.loja.roupas.trein.domain.entities.user;

import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UpdateRecoveryDTO;
import com.loja.roupas.trein.domain.entities.perfil.Perfil;
import com.loja.roupas.trein.domain.entities.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Table(name = "TBL_WENSHOP_USER")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User   {

    @Id
    @SequenceGenerator(
            name="seq_user",
            sequenceName="SEQ_TBL_WENSHOP_USER",
            schema = "SQLUTIL_OWNER",
            allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_user")
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "email", updatable = false, nullable = false, unique = true)
    private String email;

    @Column(name = "password", updatable = false, nullable = false)
    private String password;


    @OneToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

//    @OneToOne
//    @JoinColumn(name = "id_product")
//    private Product product;
    public User(CreateUserDTO createUserDTO) {
        this.email= createUserDTO.email();
        this.password = createUserDTO.password();
    }

    public User(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public void updateData(UpdateRecoveryDTO updateRecoveryDTO) {
        if(updateRecoveryDTO.password() != null) {
            this.password = updateRecoveryDTO.password();
        }
    }
}
