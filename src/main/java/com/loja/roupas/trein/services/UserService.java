package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.PerfilRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;

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
    public User create(CreateUserDTO createUserDTO) {
        var userCreated = new User(createUserDTO);

        var perfil = perfilRepository.findById(3L)
                .orElseThrow(() -> new IllegalArgumentException("Perfil não encontrado com o ID 3"));

        perfil.setId(3L);
        perfil.setNome("CLIENTE");
        userCreated.setPerfil(perfil);

        perfilRepository.save(perfil);

        userCreated.setId(userCreated.getId());
        userCreated.setEmail(userCreated.getEmail());
        userCreated.setPassword(Base64.getEncoder().encodeToString(userCreated.getPassword().getBytes()));

        return userRepository.save(userCreated);

        /*contact = new Contact();
        contact.setUser(savedUser);
        contact.setName(savedUser.getPerfil().getNome());
        contact.setDocumento(contact.getDocumento());
        contact.setAddress(contact.getAddress());
        contact.setZipcode(contact.getZipcode());
        contact.setCity(contact.getCity());
        contact.setComplement(contact.getComplement());
        contact.setComplement(contact.getComplement());
        contact.setReference_place(contact.getReference_place());

        return contactRepository.save(contact);*/
    }
        public List<User> listAll() {
            return  userRepository.findAll();
        }
    }