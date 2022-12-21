package com.example.retailer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Getter
@Setter
public class ResponseDto {

    private String message;
    private Object detail;
    private final LocalDateTime timestamp = LocalDateTime.now();
    private Object code;
}
