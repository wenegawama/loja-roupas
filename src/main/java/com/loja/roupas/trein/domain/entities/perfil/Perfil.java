package com.loja.roupas.trein.domain.entities.perfil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "perfil")
@Table(name = "TBL_WENSHOP_PERFIL")
public class Perfil implements Serializable {


    @Id
    @SequenceGenerator(name="seq_perfil", sequenceName="SEQ_TBL_WENSHOP_PERFIL", schema = "SQLUTIL_OWNER", initialValue=7, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_perfil")
    @Column(name="id",unique=true,nullable=false)
    private Long id;

    @Column(name = "name", nullable = false, updatable = false)
    private String name;
}
