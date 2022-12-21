package com.example.retailer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Entity
@Getter
@Setter
public class Transaction {

    @Id
    private Long transactionId;
    private LocalDateTime transactionDate;
    private int amount;
    @ManyToOne
    private Customer customer;
}
