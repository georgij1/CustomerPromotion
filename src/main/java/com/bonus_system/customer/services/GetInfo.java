package com.bonus_system.customer.services;

import com.bonus_system.customer.repoCustomer.CustomerRepository;
import com.bonus_system.customer.repoCustomer.Customer;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CustomerTableDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetInfo {
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
            return new CustomerTableDTO(
                    null,
                    null,
                    null
            );
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
            return new CustomerTableDTO(
                    null,
                    null,
                    null
            );
        }
    }
}