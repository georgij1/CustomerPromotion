package com.bonus_system.customer.controllers.v1;

import com.bonus_system.customer.services.GetInfo;
import com.bonus_system.customer.services.PostInfo;
import lombok.AllArgsConstructor;
import org.openapi.example.api.CustomerApi;
import org.openapi.example.model.Customer;
import org.openapi.example.model.CustomerTableDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController implements CustomerApi {
    private GetInfo getInfo;
    private PostInfo postInfo;

    @Override
    public ResponseEntity<Void> createCustomer(Customer customer) {
        postInfo.updateCustomer(customer.getNickName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CustomerTableDTO>> findByCardId(String idCard) {
        var client_find_by_cardID = Collections.singletonList(getInfo.findByCardID(idCard));
        return ResponseEntity.ok().body(client_find_by_cardID);
    }

    @Override
    public ResponseEntity<List<CustomerTableDTO>> findByClientId(Integer idCustomer) {
        var client_find_by_ClientID = Collections.singletonList(getInfo.findByClientId(idCustomer));
        return ResponseEntity.ok().body(client_find_by_ClientID);
    }

    @Override
    public ResponseEntity<Void> halfCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}