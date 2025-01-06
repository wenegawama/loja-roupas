//package com.loja.roupas.trein.services;
//
//import com.loja.roupas.trein.domain.entities.perfil.Perfil;
//import com.loja.roupas.trein.infra.exceptionsService.ResourceNotFoundException;
//import com.loja.roupas.trein.repositories.PerfilRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PerfilService {
//    @Autowired
//    private PerfilRepository perfilRepository;
//
//    public Perfil createPerfil(Perfil perfil) {
//        return  perfilRepository.save(perfil);
//    }
//
//    public List<Perfil> listPerfil() {
//        return perfilRepository.findAll();
//    }
//
//    public Perfil findById(Long id) {
//        Optional<Perfil> perfil = perfilRepository.findById(id);
//        return perfil.orElseThrow(() -> new ResourceNotFoundException(id));
//    }
//}
