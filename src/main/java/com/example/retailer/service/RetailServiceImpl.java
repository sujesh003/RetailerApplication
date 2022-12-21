package com.example.retailer.service;

import com.example.retailer.repository.RetailRepository;
import org.springframework.stereotype.Service;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Service
public class RetailServiceImpl implements RetailService {

    private final RetailRepository retailRepository;

    public RetailServiceImpl(RetailRepository retailRepository) {
        this.retailRepository = retailRepository;
    }


}
