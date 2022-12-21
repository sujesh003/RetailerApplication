package com.example.retailer;

import com.example.retailer.entity.Customer;
import com.example.retailer.entity.Transaction;
import com.example.retailer.repository.CustomerRepository;
import com.example.retailer.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class RetailerApplication extends SpringBootServletInitializer {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    public RetailerApplication(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RetailerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RetailerApplication.class);
    }

    @PostConstruct
    public void populateDataSet() {
        List<Transaction> transactionList = transactionRepository.findAll();
        if (transactionList.isEmpty()) {
            Customer customer = new Customer();
            customer.setId(1L);
            customer.setCustomerCode("123");
            customer.setName("Sujesh Shahi");
            customer.setContactNumber("9813265808");
            customerRepository.save(customer);
            Transaction transaction = new Transaction();
            transaction.setTransactionId(123L);
            transaction.setTransactionDate(LocalDateTime.of(2020, Month.NOVEMBER, 2, 2, 3));
            transaction.setAmount(80);
            transaction.setCustomer(customer);
            transactionRepository.save(transaction);
        }
    }


}
