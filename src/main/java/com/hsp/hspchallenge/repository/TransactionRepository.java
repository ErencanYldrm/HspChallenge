package com.hsp.hspchallenge.repository;

import com.hsp.hspchallenge.model.Transaction;
import com.hsp.hspchallenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long id);

    List<Transaction> findByDateAfter(LocalDate startDate);

    List<Transaction> getTransactionsByCategoryId(Long id);

}
