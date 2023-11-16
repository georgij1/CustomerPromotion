package com.bonus_system.customer;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<CustomerTable, Long> {
    @Transactional
    @Query("select customer from CustomerTable customer where customer.card_id=:idCard")
    Optional<CustomerTable> findByCardId(String idCard);

    @Modifying
    @Transactional
    @Query(value = "insert into customer(nickname, card_id) VALUES (:nickName, :cardId)", nativeQuery = true)
    void updateCustomer(@Param("nickName") String nickName, @Param("cardId") String cardId);
}