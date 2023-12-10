package com.bonus_system.customer.controllers.v1;

import com.bonus_system.customer.services.FindByCardId;
import com.bonus_system.customer.services.FindByClientId;
import com.bonus_system.customer.services.UpdateCustomer;
import lombok.AllArgsConstructor;
import org.openapi.example.api.CustomerApi;
import org.openapi.example.model.Customer;
import org.openapi.example.model.CustomerTableDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController implements CustomerApi {
    private FindByCardId findByCardId;
    private FindByClientId findByClientId;
    private UpdateCustomer updateCustomer;

    @Override
    public ResponseEntity<Void> createCustomer(Customer customer) {
        UUID uuid = UUID.randomUUID();
        updateCustomer.updateCustomer(customer.getNickName(), uuid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CustomerTableDTO>> findByCardId(String idCard) {
        return ResponseEntity.ok().body(Collections.singletonList(findByCardId.findByCardID(idCard)));
    }

    @Override
    public ResponseEntity<List<CustomerTableDTO>> findByClientId(Integer idCustomer) {
        return ResponseEntity.ok().body(Collections.singletonList(findByClientId.findByClientId(idCustomer)));
    }
}