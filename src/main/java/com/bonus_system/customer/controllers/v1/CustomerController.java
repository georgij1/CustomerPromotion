package com.bonus_system.customer.controllers.v1;

import com.bonus_system.customer.repoCustomer.Repository;
import lombok.AllArgsConstructor;
import org.openapi.example.api.CustomerApi;
import org.openapi.example.model.Customer;
import org.openapi.example.model.CustomerTable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController implements CustomerApi {
    public Repository repository;

    @Override
    public ResponseEntity<List<Customer>> createCustomer(Customer customer) {
        UUID uuid = UUID.randomUUID();
        repository.updateCustomer(customer.getNickName(), String.valueOf(uuid));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<org.openapi.example.model.CustomerTable>> findByCardId(String idCard) {
        ArrayList<CustomerTable> list = new ArrayList<>();
        list.add(repository.findByCardId(String.valueOf(idCard)));
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<List<CustomerTable>> findByClientId(String idCustomer) {
        List<CustomerTable> list = new ArrayList<>();
        list.add(repository.findByIdClient(idCustomer));
        return ResponseEntity.ok().body(list);
    }

    @Component
    public static class CustomConverter implements Converter<com.bonus_system.customer.repoCustomer.CustomerTable, CustomerTable>, com.bonus_system.customer.controllers.v1.CustomConverter {
        @Override
        public org.openapi.example.model.CustomerTable convert(com.bonus_system.customer.repoCustomer.CustomerTable source) {
            // Convert logic here
            // ...
            return new CustomerTable();
        }
    }
}