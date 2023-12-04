package com.bonus_system.customer.repoCustomer;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<com.bonus_system.customer.repoCustomer.CustomerTable, Long> {
    @Transactional
    @Query("select customer from CustomerTable customer where customer.cardId=:idCard")
    CustomerTable findByCardId(String idCard);

    @Transactional
    @Query("select customer from CustomerTable customer where customer.idclient=:idClient")
    CustomerTable findByIdClient(String idClient);

    @Modifying
    @Transactional
    @Query(value = "insert into customer(nickname, card_id) VALUES (:nickName, :cardId)", nativeQuery = true)
    void updateCustomer(@Param("nickName") String nickName, @Param("cardId") String cardId);
}