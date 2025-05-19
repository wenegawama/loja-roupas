package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.CreateCardDTO;
import com.loja.roupas.trein.domain.entities.contact.Contact;
import com.loja.roupas.trein.domain.entities.payment.Cartao;
import com.loja.roupas.trein.domain.entities.payment.MetodoPagamento;
import com.loja.roupas.trein.domain.entities.user.User;
import com.loja.roupas.trein.repositories.CardRepository;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.MetodoPagamentoRepository;
import com.loja.roupas.trein.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private MetodoPagamentoRepository metodoPagamentoRepository;



    public Cartao insert(CreateCardDTO dto) {
        Cartao cartao = new Cartao();
        MetodoPagamento metodoPagamento = new MetodoPagamento();

        log.info("Setando o método de pagamento do cartão");
        metodoPagamento.setMetodoPagamento(dto.typeCard());
        metodoPagamento.setContact(dto.idContact());

        metodoPagamentoRepository.save(metodoPagamento);


        log.info("Setando o nome do cartão");
        cartao.setNameCard(dto.nameCard());

        log.info("Setando o número do cartão");
        cartao.setNumberCard(dto.numberCard());

        log.info("Setando a validade do cartão");
        cartao.setValidity(dto.validity());

        log.info("Setando o cvc do cartão");
        cartao.setCvc(dto.cvc());

        log.info("Setando o tipo do cartão");
        cartao.setType_card(dto.typeCard());

        cartao.setMetodoPagamento(metodoPagamento);

        log.info("Salvando o cartão ....");
        return cardRepository.save(cartao);
    }

}
