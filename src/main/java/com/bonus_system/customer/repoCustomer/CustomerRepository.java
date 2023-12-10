package com.bonus_system.customer.repoCustomer;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends ListCrudRepository<CustomerTable, Long> {
    @Query(value = "select * from customer where card_id=:idCard", nativeQuery = true)
    Optional<CustomerTable> findByCardId(String idCard);
    @Query(value = "select * from customer where idclient=:idClient", nativeQuery = true)
    Optional<CustomerTable> findByIdclient(Integer idClient);

    @Transactional
    @Modifying
    @Query(value = "insert into customer(nickname, card_id) VALUES (:nickName, :uuid)", nativeQuery = true)
    void saveData(String nickName, UUID uuid);
}