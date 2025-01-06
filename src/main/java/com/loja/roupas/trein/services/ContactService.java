//package com.loja.roupas.trein.services;
//
//import com.loja.roupas.trein.domain.dto.contactDTO.CreateContactDTO;
//import com.loja.roupas.trein.domain.entities.contact.Contact;
//import com.loja.roupas.trein.domain.entities.user.User;
//import com.loja.roupas.trein.repositories.ContactRepository;
//import com.loja.roupas.trein.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ContactService {
//
//    @Autowired
//    private ContactRepository contactRepository;
//
//
//    public Contact create(CreateContactDTO createContactDTO) {
//        var contact = new Contact(createContactDTO);
//        return contactRepository.save(contact);
//    }
//}
