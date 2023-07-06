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
    List<Transaction> getTransactionsByUser(User user);
    List<Transaction> getTransactionsByDateRange(LocalDate startDate, LocalDate endDate);
}