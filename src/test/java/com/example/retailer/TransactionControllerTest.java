package com.example.retailer;

import com.example.retailer.dto.CustomerReward;
import com.example.retailer.dto.ResponseDto;
import com.example.retailer.entity.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Sujesh Shahi on  12/22/2022
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getQuarterlyRewards() throws Exception {
        String uri = "/v1/retail/reward-points";
        mockMvc.perform(get(uri))
                .andDo(print())
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
