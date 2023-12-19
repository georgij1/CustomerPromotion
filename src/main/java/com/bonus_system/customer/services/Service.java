package com.bonus_system.customer.services;

import com.bonus_system.customer.repoCustomer.CustomerRepository;
import com.bonus_system.customer.repoCustomer.Customer;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CustomerTableDTO;

import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service implements ServiceImpl {
    public CustomerRepository customerRepository;

    public CustomerTableDTO findByCardID(String cardId) {
        Optional<Customer> cardOptional = customerRepository.findByCardId(cardId);
        if (cardOptional.isPresent()) {
            var customer = cardOptional.get();
            return new CustomerTableDTO(
                    customer.getId_client(),
                    customer.getNick_name(),
                    customer.getCard_id()
            );
        }

        else {
            throw new RuntimeException("Client by CardId is not found");
        }
    }

    public CustomerTableDTO findByClientId(
            Integer idCustomer
    ) {
        Optional<Customer> cardOptional = customerRepository.findByIdclient(idCustomer);
        if (cardOptional.isPresent()) {
            var customer = cardOptional.get();
            return new CustomerTableDTO(
                    customer.getId_client(),
                    customer.getNick_name(),
                    customer.getCard_id()
            );
        }

        else {
            throw new RuntimeException("Client by ClientId is not found");
        }
    }

    public void updateCustomer(
            String nickName
    ) {
        customerRepository.saveData(nickName, UUID.randomUUID());
    }
}