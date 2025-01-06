package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
