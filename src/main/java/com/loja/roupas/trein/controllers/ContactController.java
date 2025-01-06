//package com.loja.roupas.trein.controllers;
//
//import com.loja.roupas.trein.domain.dto.contactDTO.CreateContactDTO;
//import com.loja.roupas.trein.domain.entities.contact.Contact;
//import com.loja.roupas.trein.services.ContactService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//
//@RestController
//@RequestMapping("/api/v1/contacts")
//public class ContactController {
//
//    @Autowired
//    private ContactService contactService;
//
//    @PostMapping
//    public ResponseEntity<Contact> insert(@RequestBody @Valid CreateContactDTO createContactDTO) {
//       var contactCreated = contactService.create(createContactDTO);
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(contactCreated.getId()).toUri();
//        return ResponseEntity.created(uri).body(contactCreated);
//    }
//}
