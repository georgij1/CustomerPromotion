package com.bonus_system.customer.services;

import org.openapi.example.model.CustomerTableDTO;

public interface ServiceImpl {
    CustomerTableDTO findByCardID(String cardId);
    CustomerTableDTO findByClientId(Integer idCustomer);
    void updateCustomer(String nickName);
}