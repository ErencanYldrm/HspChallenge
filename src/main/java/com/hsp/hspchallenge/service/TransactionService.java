package com.hsp.hspchallenge.service;


import com.hsp.hspchallenge.model.Category;
import com.hsp.hspchallenge.model.Transaction;
import com.hsp.hspchallenge.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getTransactionsByUserId(Long id);

    void deleteTransaction(Long transactionId);
    List<Transaction> getTransactionsByDateAfter(LocalDate startDate);
}
