package com.example.retailer.controller;

import com.example.retailer.dto.CustomerReward;
import com.example.retailer.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.retailer.constants.RetailConstant.RETAIL;
import static com.example.retailer.constants.RetailConstant.REWARD_POINTS;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@RestController
@RequestMapping(RETAIL)
public class RetailController {

    private final TransactionService transactionService;

    RetailController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(REWARD_POINTS)
    public ResponseEntity<List<CustomerReward>> getRewardPointsByQuarter() {
        List<CustomerReward> customerRewards = transactionService.getRewardPointsByQuarter();
        return ResponseEntity.ok(customerRewards);
    }
}
