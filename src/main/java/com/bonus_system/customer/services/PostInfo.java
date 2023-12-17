package com.bonus_system.customer.services;

import com.bonus_system.customer.repoCustomer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PostInfo {
    public CustomerRepository customerRepository;

    public void updateCustomer(
            String nickName
    ) {
        customerRepository.saveData(nickName, UUID.randomUUID());
    }
}