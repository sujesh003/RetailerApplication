package com.example.retailer.service;

import com.example.retailer.dto.CustomerReward;
import com.example.retailer.entity.Customer;
import com.example.retailer.entity.Transaction;
import com.example.retailer.exception.RetailException;
import com.example.retailer.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);


    @Override
    public List<CustomerReward> getRewardPointsByQuarter() {
        List<Transaction> transactions = transactionRepository.findAll();
        logger.info("Getting transactions {}", transactions);
        if (transactions.isEmpty()) {
            throw new RetailException("No any transactions available");
        }
        Map<Customer, List<Transaction>> transactionGroupByCustomer = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getCustomer, Collectors.toList()));

        List<CustomerReward> customerRewards = new ArrayList<>();

        transactionGroupByCustomer.forEach((customer, transactionList) -> {
            CustomerReward customerReward = getCustomerReward(transactionList);
            customerReward.setCustomerName(customer.getName());
            customerRewards.add(customerReward);
        });
        return customerRewards;
    }

    public CustomerReward getCustomerReward(List<Transaction> transactions) {
        Map<String, Integer> rewardsCollectedByMonth = transactions
                .stream()
                .map(transaction -> {
                    String month = transaction.getTransactionDate().getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
                    int amount = calculateReward(transaction.getAmount());
                    return Pair.of(month, amount);
                }).collect(Collectors.groupingBy(Pair::getFirst, Collectors.summingInt(Pair::getSecond)));
        CustomerReward customerReward = new CustomerReward();
        customerReward.setRewards(rewardsCollectedByMonth);
        int total = rewardsCollectedByMonth.values().stream().mapToInt(i -> i).sum();
        customerReward.setTotal(total);
        return customerReward;
    }

    public int calculateReward(int amountSpent) {
        if (amountSpent < 50) {
            return 0;
        }
        if (amountSpent >= 100) {
            return 50 + (amountSpent - 100) * 2;
        }
        return amountSpent - 50;
    }
}
