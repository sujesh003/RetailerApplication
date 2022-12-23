package com.example.retailer.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Entity
@Getter
@Setter
@ToString
public class Transaction {

    @Id
    private Long transactionId;
    private LocalDateTime transactionDate;
    private int amount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
