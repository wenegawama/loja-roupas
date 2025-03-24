package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.auth.AuthenticationDTO;
import com.loja.roupas.trein.domain.dto.contactDTO.RecoveryContactDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UpdateRecoveryDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UserUpdated;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.infra.exceptionsService.RecupercaoSenhaException;
import com.loja.roupas.trein.infra.exceptionsService.ResourceNotFoundException;
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
        user.setPassword(Base64.getEncoder().encodeToString(userConected.getPassword().getBytes()));
        user.setPerfil(userConected.getPerfil());

        log.info("Procurando o contact pelo  usuário");
        var c = contactRepository.findByUser(userConected);

        contact.setId(c.getId());
        contact.setName(c.getName());
        contact.setDocumento(c.getDocumento());
        contact.setZipcode(c.getZipcode());
        contact.setCity(c.getCity());
        contact.setNeighborhood(c.getNeighborhood());
        contact.setStreet(c.getStreet());
        contact.setNumero(c.getNumero());
        contact.setComplement(c.getComplement());
        contact.setPhone(c.getPhone());
        contact.setReference_place(c.getReference_place());
        contact.setPergunta(c.getPergunta());
        contact.setResposta_pergunta(c.getResposta_pergunta());
        contact.setUser(user);

        log.info("Retornando o contact no login: Fim do processo de login");
        return contact;
    }

    public Contact isRecovery(RecoveryContactDTO recoveryContactDTO) {

        log.info("Procurando o documento,email,pergunta e resposta secreta");
        var contact = contactRepository.findByDocumentoAndEmailAndPerguntaAndResposta(recoveryContactDTO.documento(), recoveryContactDTO.email(), recoveryContactDTO.pergunta_secreta(),recoveryContactDTO.resposta_secreta());

        if(contact == null) {
            log.info("Dados não encontrados");
            throw new RecupercaoSenhaException("Dados recuperação inválidos");//tela
        }

        return contact; //salvar no front
    }

    public UserUpdated updatePassword(Long id, UpdateRecoveryDTO updateRecoveryDTO) {
        var user = userRepository.getReferenceById(updateRecoveryDTO.id());

        user.updateData(updateRecoveryDTO);

        return new UserUpdated(user);
    }
}