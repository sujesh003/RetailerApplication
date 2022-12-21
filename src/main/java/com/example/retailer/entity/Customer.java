package com.example.retailer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Entity
@Getter
@Setter
public class Customer {

    @Id
    private Long id;
    @Column(unique = true, nullable = false)
    private String customerCode;
    private String name;
    private String contactNumber;
}
