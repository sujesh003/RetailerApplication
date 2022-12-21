package com.example.retailer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

/**
 * @author Sujesh Shahi on  12/21/2022
 */
@Entity
@Getter
@Setter
public class Customer extends AbstractPersistable<Long> {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModifiedAt = LocalDateTime.now();

    @Version
    private int version;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(unique = true, nullable = false)
    private String customerCode;
    private String name;
    @Column(nullable = false)
    private String transactionAmount;
    private String contactNumber;
}
