package com.bonus_system.customer.services;

import com.bonus_system.customer.repoCustomer.CustomerRepository;
import com.bonus_system.customer.repoCustomer.CustomerTable;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CustomerTableDTO;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindByCardId {
    public CustomerRepository customerRepository;

    public CustomerTableDTO findByCardID(String cardId) {
        Optional<CustomerTable> cardOptional = customerRepository.findByCardId(cardId);
        var customer = cardOptional.get();
        return new CustomerTableDTO(customer.getIdclient(), customer.getNickname(), customer.getCardId());
    }
}