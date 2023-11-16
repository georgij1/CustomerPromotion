package com.bonus_system.customer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class CustomerTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idclient;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "card_id")
    private String card_id;
}