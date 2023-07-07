package com.hsp.hspchallenge.service;


import com.hsp.hspchallenge.model.Category;
import com.hsp.hspchallenge.model.Transaction;
import com.hsp.hspchallenge.model.User;
import com.hsp.hspchallenge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        Transaction transaction1 = transactionRepository.save(transaction);
        return transaction1;
    }

    public List<Transaction> getTransactionsByUserId(Long id) {
        return transactionRepository.findByUserId(id);
    }

    public List<Transaction> getTransactionsByDateAfter(LocalDate startDate) {
        return transactionRepository.findByDateAfter(startDate);
    }

    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    public List<Transaction> getTransactionsByCategoryId(Long id) {
        return transactionRepository.getTransactionsByCategoryId(id);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }


}
