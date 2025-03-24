package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.sellerDTO.CreateSellerDTO;
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
public class SellerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ContactRepository contactRepository;

    private Contact contact;
    @Transactional
    public Contact create(CreateSellerDTO createSellerDTO) {
        log.info("Iniciando a classe service do vendedor!!");
        var userCreated = new User();

         //var perfil = perfilRepository.findById(1L)
                //.orElseThrow(() -> new IllegalArgumentException("Perfil não encontrado com o ID 1"));

        userCreated.setEmail(createSellerDTO.email());
        userCreated.setPassword(Base64.getEncoder().encodeToString(createSellerDTO.password().getBytes()));

        var perfil = perfilRepository.findByName(createSellerDTO.perfil());//try catch
        userCreated.setPerfil(perfil);

        log.info("Salvando o vendedor!!");
        var savedUser = userRepository.save(userCreated);

        contact = new Contact();
        contact.setUser(savedUser);
        contact.setName(createSellerDTO.name());
        contact.setDocumento(createSellerDTO.documento());
        contact.setZipcode(createSellerDTO.zipcode());
        contact.setCity(createSellerDTO.city());
        contact.setComplement(createSellerDTO.complement());
        contact.setPhone(createSellerDTO.phone());
        contact.setReference_place(createSellerDTO.reference_place());
        contact.setPergunta(createSellerDTO.pergunta());
        contact.setResposta_pergunta(createSellerDTO.resposta_pergunta());

        log.info("Salvando o vendedor com as informações do contacto!!");
        return contactRepository.save(contact);
    }
        public List<Contact> listAll() {
            return  contactRepository.findAll();
        }

    }