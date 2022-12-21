package com.example.retailer.service;

import com.example.retailer.dto.CustomerReward;

import java.util.List;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
public interface TransactionService {

    List<CustomerReward> getRewardPointsByQuarter();


}
