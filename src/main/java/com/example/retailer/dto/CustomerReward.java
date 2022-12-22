package com.example.retailer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Getter
@Setter
@ToString
public class CustomerReward {

    private String customerName;
    private Map<String, Integer> rewards;
    private int total;
}
