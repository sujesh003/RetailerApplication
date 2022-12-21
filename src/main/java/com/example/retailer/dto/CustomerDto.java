package com.example.retailer.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Getter
@Setter
public class CustomerDto {

    private String customerCode;
    private String name;
    private String transactionAmount;
    private String contactNumber;
}
