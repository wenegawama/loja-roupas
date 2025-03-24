package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.PerfilRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ContactRepository contactRepository;
    private Contact contact;
    @Transactional
    public Contact create(CreateUserDTO createUserDTO) {
        log.info("Iniciando a classe service do user!!");
        var userCreated = new User();
        //verificar se tem o email já para não repetir.

        userCreated.setEmail(createUserDTO.email());
        userCreated.setPassword(Base64.getEncoder().encodeToString(createUserDTO.password().getBytes()));

        var emailUser = userRepository.findByEmail(createUserDTO.email());
        if(emailUser != null) {
            throw new RuntimeException("Email já existe");
        }

        var perfil = perfilRepository.findByName(createUserDTO.perfil());//try catch rever toStir
        userCreated.setPerfil(perfil);

        log.info("Salvando o usuário!!");
        var savedUser = userRepository.save(userCreated);

        contact = new Contact();
        contact.setUser(savedUser);
        contact.setName(createUserDTO.name());
        contact.setDocumento(createUserDTO.documento());
        contact.setZipcode(createUserDTO.zipcode());
        contact.setCity(createUserDTO.city());
        contact.setNeighborhood(createUserDTO.neighborhood());
        contact.setStreet(createUserDTO.street());
        contact.setNumero(createUserDTO.numero());
        contact.setComplement(createUserDTO.complement());
        contact.setPhone(createUserDTO.phone());
        contact.setReference_place(createUserDTO.reference_place());
        contact.setPergunta(createUserDTO.pergunta());
        contact.setResposta_pergunta(createUserDTO.resposta_pergunta());

        log.info("Salvando o usuário com as informações do contacto!!");
        return contactRepository.save(contact);
    }
        public List<Contact> listAllContact() {
            return  contactRepository.findAll();
        }
    }

