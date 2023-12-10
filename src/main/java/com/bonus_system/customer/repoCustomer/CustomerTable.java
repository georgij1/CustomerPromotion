package com.bonus_system.customer.repoCustomer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Accessors(chain = true)
@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idclient;
    @Column("nickname")
    private String nickname;
    @Column("card_id")
    private String cardId;
}