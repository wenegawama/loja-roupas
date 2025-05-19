package com.loja.roupas.trein.services;

import com.loja.roupas.trein.domain.dto.MetodoPagamentoDTO;
import com.loja.roupas.trein.domain.entities.payment.MetodoPagamento;
import com.loja.roupas.trein.repositories.ContactRepository;
import com.loja.roupas.trein.repositories.MetodoPagamentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MetodoPagamentoService {

    @Autowired
    private MetodoPagamentoRepository metodoPagamentoRepository;

    @Autowired
    private ContactRepository contactRepository;

    public MetodoPagamento insert(MetodoPagamentoDTO dto) {
        if (dto.idContact() == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        MetodoPagamento metodoPagamento = new MetodoPagamento();

        log.info("Setando o método de pagamento.");
        metodoPagamento.setMetodoPagamento(dto.metodoPagamento());

        var newId = contactRepository.findById(dto.idContact().getId())
                .orElseThrow(() -> new IllegalArgumentException("Contact not found with id: " + dto.idContact().getId()));

        log.info("Setando o id do contato.");
        metodoPagamento.setContact(newId);

        return metodoPagamentoRepository.save(metodoPagamento);
    }
}