package com.example.retailer.repository;

import com.example.retailer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Repository
public interface RetailRepository extends JpaRepository<Customer, Long> {
}
