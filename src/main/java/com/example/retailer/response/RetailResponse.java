package com.example.retailer.response;

import com.example.retailer.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
public class RetailResponse {

    public static ResponseEntity<ResponseDto> successResponse(Object o) {
        ResponseDto r = new ResponseDto();
        r.setDetail(o);
        r.setMessage("SUCCESS");
        r.setCode(HttpStatus.OK.value());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    public static ResponseEntity<ResponseDto> failResponseWithStatus(HttpStatus httpStatus, String message) {
        ResponseDto r = new ResponseDto();
        r.setMessage(message);
        r.setCode(httpStatus.value());
        return new ResponseEntity<>(r, httpStatus);
    }
}
