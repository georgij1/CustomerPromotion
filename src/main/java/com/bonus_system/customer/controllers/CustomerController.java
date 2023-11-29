package com.bonus_system.customer.controllers;

import com.bonus_system.customer.repoCustomer.Repository;
import lombok.AllArgsConstructor;
import org.openapi.example.api.CustomerApi;
import org.openapi.example.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController implements CustomerApi {
    public Repository repository;

    public ResponseEntity<?> findByCardID(Long idCustomer, Integer card_id) {
        return ResponseEntity.ok().body(repository.findByCardId(String.valueOf(card_id)));
    }

    public ResponseEntity<?> findByCustomerId(Long idCustomer) {
        return ResponseEntity.ok().body(repository.findById(idCustomer));
    }

    public ResponseEntity<List<Customer>> createCustomer(Long idCard, Customer customer) {
        UUID uuid = UUID.randomUUID();
        repository.updateCustomer(customer.getNickName(), String.valueOf(uuid));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}