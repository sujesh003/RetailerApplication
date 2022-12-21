package com.example.retailer.mapper;

import com.example.retailer.dto.CustomerDto;
import com.example.retailer.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.retailer.mapper.CustomerMapper.SPRING_MODEL;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Component
@Mapper(componentModel = SPRING_MODEL)
public abstract class CustomerMapper {
    public static final String SPRING_MODEL = "spring";

    public abstract CustomerDto mapEntityToDto(Customer customer);

    public abstract List<CustomerDto> mapEntitiesToDtos(List<Customer> customerDtoList);
}
