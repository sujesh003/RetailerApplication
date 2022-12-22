package com.example.retailer;

import com.example.retailer.controller.RetailController;
import com.example.retailer.dto.CustomerReward;
import com.example.retailer.dto.ResponseDto;
import com.example.retailer.entity.Transaction;
import com.example.retailer.repository.TransactionRepository;
import com.example.retailer.service.TransactionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Sujesh Shahi on  12/22/2022
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @InjectMocks
    TransactionServiceImpl transactionServiceImpl;
    @InjectMocks
    private RetailController retailController;

    @Mock
    private TransactionRepository transactionRepository;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        // We would need this line if we would not use the MockitoExtension
        // MockitoAnnotations.initMocks(this);
        // Here we can't use @AutoConfigureJsonTesters because there isn't a Spring context
//        JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
        mockMvc = MockMvcBuilders.standaloneSetup(retailController)
                .build();
    }

    @Test
    public void getQuarterlyRewards() throws Exception {
        String uri = "/v1/retail/reward-points";

        List<Transaction> transactions = transactionRepository.findAll();
        List<CustomerReward> actualCustomerRewards = getCustomerRewards();
        List<CustomerReward> expectedCustomerRewards = transactionServiceImpl.getRewardPointsByQuarter();
        when(transactionServiceImpl.getRewardPointsByQuarter()).thenReturn(expectedCustomerRewards);
        mockMvc.perform(get(uri))
                .equals(getResponseDto());
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

    private ResponseEntity<ResponseDto> getResponseDto() {
        ResponseDto r = new ResponseDto();
        r.setDetail(getCustomerRewards());
        r.setMessage("SUCCESS");
        r.setCode(HttpStatus.OK.value());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
}
