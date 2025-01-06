package com.loja.roupas.trein.domain.entities.perfil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;



@AllArgsConstructor
@Data
@Entity(name = "perfil")
@Table(name = "TBL_WENSHOP_PERFIL")
public class Perfil implements Serializable {


    @Id
    @SequenceGenerator(name="seq_perfil", sequenceName="SEQ_TBL_WENSHOP_PERFIL", schema = "SQLUTIL_OWNER", initialValue=7, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_perfil")
    @Column(name="id",unique=true,nullable=false)
    private Long id;
    private String nome;

    //nao precisa mapear o relacionamento com user
    public Perfil() {
    }
}
