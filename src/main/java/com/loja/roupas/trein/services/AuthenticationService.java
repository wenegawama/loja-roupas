package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.auth.AuthenticationDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.infra.exceptionsService.ValidationException;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Slf4j
@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    public Contact doLogin(AuthenticationDTO authenticationDTO) {

        log.info("Inciciando o prosesso de login");
        User user = new User();
        Contact contact = new Contact();

        var passwordCripto = Base64.getEncoder().encodeToString(authenticationDTO.password().getBytes());

        User userConected = userRepository.findByEmailAndPassword(authenticationDTO.email(), passwordCripto);

        if (userConected == null) {
            log.info("Lançando a exessão : Usuario e senha não encontrado!!!");
            throw new ValidationException("Usuario  não encontrado, por favor insira os dados corretamente");
        }
        log.info("Login com sucesso!!!");

        user.setId(userConected.getId());
        user.setEmail(userConected.getEmail());
        user.setPerfil(userConected.getPerfil());

        log.info("Procurando o contact pelo  usuário");
        var c = contactRepository.findByUser(userConected);

        contact.setId(c.getId());
        contact.setName(c.getName());
        contact.setDocumento(c.getDocumento());
        contact.setAddress(c.getAddress());
        contact.setZipcode(c.getZipcode());
        contact.setCity(c.getCity());
        contact.setComplement(c.getComplement());
        contact.setPhone(c.getPhone());
        contact.setReference_place(c.getReference_place());
        contact.setPergunta(c.getPergunta());
        contact.setResposta_pergunta(c.getResposta_pergunta());
        contact.setUser(user);

        log.info("Retornando o contact");
        return contact;
    }
}