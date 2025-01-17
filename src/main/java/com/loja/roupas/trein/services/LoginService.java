package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.userDTO.CreateUserDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.infra.exceptionsService.ValidationException;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.PerfilRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private ContactRepository contactRepository;

    public User doLogin(CreateUserDTO createUserDTO){

        var passwordCripto = Base64.getEncoder().encodeToString(createUserDTO.password().getBytes());
        var userConected = userRepository.findByEmailAndPassword(createUserDTO.email(), passwordCripto);

        if(userConected == null){
            log.error("Usuário com erro no login ");

            throw new ValidationException("Usuario  não encontrado, por favor insira os dados corretamente");
        }
        log.info("Usuário com login efetuado com sucesso: usuário conectado!!!");
        return userConected; // -> mandar no frontend a pagina do usuario connectado
    }

    //recuperar a senha da segunda opção
    public User isRecoverPassword(CreateUserDTO createUserDTO){

        var userFound = contactRepository.findByDocumentoAndEmailAndPerguntaAndResposta(createUserDTO.documento(), createUserDTO.email(), createUserDTO.pergunta(), createUserDTO.resposta_pergunta());//perg e res

        if(userFound == null) {
            log.info("A recuperação deu erro, favor conferir novamente os dados informados!!!");
            throw new ValidationException("Erro: os dados não conferem");
        }
        log.info("Usuário achado para recuperar a senha");

        User u = userFound.getUser();


        return u;
    }

    //criar outro metodo para atualizar o user

    public User updateUser(CreateUserDTO createUserDTO) {
        User newUser = new User();
        newUser.setPassword(createUserDTO.password());//atualizar e criptografar

        return newUser;
    }

/*
    public UserVO recoverPassword(UserVO user){
        UserBD usrBD = new UserBD();
        ContactBD contactBD = new ContactBD();

        usrBD.setEmail(user.getEmail());
        usrBD.setSenha(Base64.parse(user.getSenha));

        UserDAO usrDAO = new UserDAO();
        UserBD usrBD = usrDAO.updatePassword(contactBD);

        return usrBD;
    }
*/
}
