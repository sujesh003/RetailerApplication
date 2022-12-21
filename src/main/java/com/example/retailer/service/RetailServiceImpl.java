package com.example.retailer.service;

import com.example.retailer.repository.TransactionRepository;
import org.springframework.stereotype.Service;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Service
public class RetailServiceImpl implements RetailService {

    private final TransactionRepository retailRepository;

    public RetailServiceImpl(TransactionRepository retailRepository) {
        this.retailRepository = retailRepository;
    }


}
