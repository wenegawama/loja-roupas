package com.loja.roupas.trein.repositories;

import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT c FROM contact c WHERE c.documento = ?1 AND c.user.email = ?2 AND c.pergunta = ?3 AND c.respostaPergunta = ?4 ")
    Contact findByDocumentoAndEmailAndPerguntaAndResposta(String documento, String email,String pergunta, String respostaPergunta);

    @Query(value = "SELECT c FROM contact c WHERE c.user.email = ?1 AND c.user.password = ?2")
    Contact findByEmailAndPassword(String email, String password);
    @Query("SELECT c FROM contact c WHERE c.user = ?1")
    Contact findByUser(User user);

}
