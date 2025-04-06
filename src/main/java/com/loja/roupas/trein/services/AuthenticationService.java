package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.auth.AuthenticationDTO;
import com.loja.roupas.trein.domain.dto.contactDTO.RecoveryContactDTO;
import com.loja.roupas.trein.domain.dto.userDTO.UpdateRecoveryDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.infra.exceptionsService.RecupercaoSenhaException;
import com.loja.roupas.trein.infra.exceptionsService.ValidationException;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        var passwordCripto = Base64.getEncoder().encodeToString(authenticationDTO.password().getBytes());

        var userConected = contactRepository.findByEmailAndPassword(authenticationDTO.email(), passwordCripto);

        if (userConected == null) {
            log.info("Lançando a exessão : Email ou senha não encontrado!!!");
            throw new ValidationException("Usuario  não encontrado, por favor insira os dados corretamente");
        }

        log.info("Login com sucesso!!! - Retornando o contact no login: Fim do processo de login");
        return userConected;
    }

    public Contact isRecovery(RecoveryContactDTO recoveryContactDTO) {

        log.info("Procurando o documento,email,pergunta e resposta secreta");
        var contact = contactRepository.findByDocumentoAndEmailAndPerguntaAndResposta(recoveryContactDTO.documento(), recoveryContactDTO.email(), recoveryContactDTO.pergunta(),recoveryContactDTO.respostaPergunta());

        if(contact == null) {
            log.info("Dados não encontrados");
            throw new RecupercaoSenhaException("Dados recuperação inválidos");//tela
        }

        return contact; //salvar no front
    }

    @Transactional
    public User updatePassword(UpdateRecoveryDTO updateRecoveryDTO) {

        User user = userRepository.findById(updateRecoveryDTO.id()).orElseThrow(() -> new RuntimeException("User not founf!"));

        log.info("Senha atual: " + user.getPassword());
        user.setPassword(updateRecoveryDTO.password());

        user.updateData();
        log.info("Senha codificada: " + user.getPassword());

        userRepository.save(user);
        log.info("Usuário atualizado: " + user.getPassword());

        userRepository.flush();

        return user;

        //return new UserUpdated(user);
    }
}