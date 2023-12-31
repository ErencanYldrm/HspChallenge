package com.hsp.hspchallenge.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {

    public Transaction(Long id , BigDecimal amount , Long categoryId, Long userId){
        this.id = id;
        this.amount = amount;
        this.categoryId = categoryId;
        this.userId = userId;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date = LocalDate.now();

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name="category_id", nullable = false)
    private Long categoryId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

}
