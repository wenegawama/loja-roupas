package com.loja.roupas.trein.domain.entities.seller;

import com.loja.roupas.trein.domain.dto.sellerDTO.CreateSellerDTO;
import com.loja.roupas.trein.domain.dto.sellerDTO.UpdateSellerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity(name = "Seller")
@Table(name = "sellers")
public class Seller {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String cnpj;
    private String fone;
    private String email;
    private Boolean active;

    public Seller() {
    }

    public Seller(Long id, String name, String surname, String cnpj, String fone, String email, Boolean active) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cnpj = cnpj;
        this.fone = fone;
        this.email = email;
        this.active = active;
    }

    public Seller(CreateSellerDTO createSellerDTO) {
        this.name = createSellerDTO.name();
        this.surname = createSellerDTO.surname();
        this.cnpj = createSellerDTO.cnpj();
        this.fone = createSellerDTO.fone();
        this.email = createSellerDTO.email();
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void updateSeller(UpdateSellerDTO updateSellerDTO) {
        if(updateSellerDTO.name() != null) {
            this.name = updateSellerDTO.name();
        }
        if(updateSellerDTO.surname() != null) {
            this.surname = updateSellerDTO.surname();
        }
        if(updateSellerDTO.cnpj() != null) {
            this.cnpj = updateSellerDTO.cnpj();
        }
        if(updateSellerDTO.fone() != null) {
            this.fone = updateSellerDTO.fone();
        }
        if(updateSellerDTO.email() != null) {
            this.email = updateSellerDTO.email();
        }
    }

    public void deleteSeller() {
        this.active = false;
    }
}