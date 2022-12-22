package com.example.retailer;

import com.example.retailer.dto.CustomerReward;
import com.example.retailer.entity.Customer;
import com.example.retailer.entity.Transaction;
import com.example.retailer.repository.TransactionRepository;
import com.example.retailer.service.TransactionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author Sujesh Shahi on  12/22/2022
 */
@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    TransactionServiceImpl transactionServiceImpl;


    @Test
    public void calculateReward() {
        int expectedReward = 30;
        int actualReward = transactionServiceImpl.calculateReward(80);
        assertThat(expectedReward).isSameAs(actualReward);
    }

    @Test
    public void getCustomerReward() {
        List<Transaction> transactions = getTransactions();
        CustomerReward actualCustomerReward = transactionServiceImpl.getCustomerReward(transactions);

        CustomerReward expectedCustomerReward = new CustomerReward();
        expectedCustomerReward.setTotal(30);
        Map<String, Integer> rewards = new HashMap<>();
        rewards.put("Nov", 30);
        expectedCustomerReward.setRewards(rewards);

        assertEquals(actualCustomerReward.getRewards(), expectedCustomerReward.getRewards());
        assertEquals(actualCustomerReward.getTotal(), expectedCustomerReward.getTotal());
    }

    @Test
    public void getRewardPointsByQuarter() {
        List<Transaction> transactions = getTransactions();
        when(transactionRepository.findAll()).thenReturn(transactions);
        List<CustomerReward> expectedCustomerRewards = transactionServiceImpl.getRewardPointsByQuarter();
        List<CustomerReward> actualCustomerRewards = getCustomerRewards();

        assertEquals(expectedCustomerRewards.get(0).getRewards(), actualCustomerRewards.get(0).getRewards());
        assertEquals(expectedCustomerRewards.get(0).getCustomerName(), actualCustomerRewards.get(0).getCustomerName());
        assertEquals(expectedCustomerRewards.get(0).getTotal(), actualCustomerRewards.get(0).getTotal());

        System.out.println("expected" + expectedCustomerRewards);
        System.out.println("actual" + actualCustomerRewards);
//        assertThat(actualCustomerRewards, is(expectedCustomerRewards));
//        assertTrue(expectedCustomerRewards.equals(actualCustomerRewards));
//        assertTrue(expectedCustomerRewards.containsAll(actualCustomerRewards) && actualCustomerRewards.containsAll(expectedCustomerRewards));
    }

    private List<CustomerReward> getCustomerRewards() {
        List<CustomerReward> customerRewards = new ArrayList<>();
        CustomerReward customerReward = new CustomerReward();
        customerReward.setTotal(30);
        Map<String, Integer> rewards = new HashMap<>();
        rewards.put("Nov", 30);
        customerReward.setRewards(rewards);
        customerReward.setCustomerName("Sujesh Shahi");
        customerRewards.add(customerReward);
        return customerRewards;
    }

    private List<Transaction> getTransactions() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCustomerCode("123");
        customer.setName("Sujesh Shahi");
        customer.setContactNumber("9813265808");

        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setTransactionId(123L);
        transaction.setTransactionDate(LocalDateTime.of(2020, Month.NOVEMBER, 2, 2, 3));
        transaction.setAmount(80);
        transaction.setCustomer(customer);
        transactions.add(transaction);
        return transactions;
    }
}
