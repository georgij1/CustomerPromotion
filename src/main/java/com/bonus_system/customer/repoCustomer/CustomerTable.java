package com.bonus_system.customer.repoCustomer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class CustomerTable extends org.openapi.example.model.CustomerTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idclient;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "card_id")
    private String cardId;
}