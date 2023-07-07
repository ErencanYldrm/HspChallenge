package com.hsp.hspchallenge.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    public User(String name, String email, String password , BigDecimal balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;


}
