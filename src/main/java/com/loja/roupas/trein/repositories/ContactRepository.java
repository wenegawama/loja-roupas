package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT c FROM  contact c WHERE c.documento = ?1 AND c.user.email = ?2 AND c.pergunta = ?3 AND c.resposta_pergunta = ?4 ")
    Contact findByDocumentoAndEmailAndPerguntaAndResposta(String documento, String email,String pergunta, String resposta_pergunta);//
}
