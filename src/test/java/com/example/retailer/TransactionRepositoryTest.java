package com.example.retailer;

import com.example.retailer.entity.Customer;
import com.example.retailer.entity.Transaction;
import com.example.retailer.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author Sujesh Shahi on  12/22/2022
 */
@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

    @Mock
    TransactionRepository transactionRepository;

    @Test
    public void saveTransaction() {
        Transaction transaction = getTransaction();
        Mockito.lenient().when(transactionRepository.save(any())).thenReturn(transaction);
    }

    private Transaction getTransaction() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCustomerCode("123");
        customer.setName("Sujesh Shahi");
        customer.setContactNumber("9813265808");

        Transaction transaction = new Transaction();
        transaction.setTransactionId(123L);
        transaction.setTransactionDate(LocalDateTime.of(2020, Month.NOVEMBER, 2, 2, 3));
        transaction.setAmount(80);
        transaction.setCustomer(customer);
        return transaction;
    }
}
