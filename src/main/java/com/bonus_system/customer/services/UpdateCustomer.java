package com.bonus_system.customer.services;

import com.bonus_system.customer.repoCustomer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateCustomer {
    public CustomerRepository customerRepository;

    public void updateCustomer (
            String nickName,
            UUID uuid
    ) {
        customerRepository.saveData(nickName, uuid);
    }
}