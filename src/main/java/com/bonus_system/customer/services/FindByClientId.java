package com.bonus_system.customer.services;

import com.bonus_system.customer.repoCustomer.CustomerRepository;
import com.bonus_system.customer.repoCustomer.CustomerTable;
import lombok.AllArgsConstructor;
import org.openapi.example.model.CustomerTableDTO;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindByClientId {
    public CustomerRepository customerRepository;

    public CustomerTableDTO findByClientId (
            Integer idCustomer
    ) {
        System.out.println(idCustomer);
        Optional<CustomerTable> cardOptional = customerRepository.findByIdclient(idCustomer);
        System.out.println(customerRepository.findByIdclient(idCustomer));
        var customer = cardOptional.get();
        return new CustomerTableDTO(customer.getIdclient(), customer.getNickname(), customer.getCardId());
    }
}