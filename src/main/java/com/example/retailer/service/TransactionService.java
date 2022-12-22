package com.example.retailer.service;

import com.example.retailer.dto.CustomerReward;
import com.example.retailer.entity.Transaction;

import java.util.List;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
public interface TransactionService {

    List<CustomerReward> getRewardPointsByQuarter();

    int calculateReward(int amountSpent);

    CustomerReward getCustomerReward(List<Transaction> transactions);


}
