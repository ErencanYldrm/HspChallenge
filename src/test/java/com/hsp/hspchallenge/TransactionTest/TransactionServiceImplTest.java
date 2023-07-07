package com.hsp.hspchallenge.TransactionTest;

import com.hsp.hspchallenge.model.Category;
import com.hsp.hspchallenge.model.Transaction;
import com.hsp.hspchallenge.model.User;
import com.hsp.hspchallenge.service.TransactionServiceImpl;
import com.hsp.hspchallenge.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TransactionServiceImplTest {

    @Autowired
    private TransactionServiceImpl transactionService;
    @Autowired
    private UserService userService;

    @Test
    void createTransaction() {
        User user = new User(1L,"test","test","test",new BigDecimal("1000.00"));
        userService.createUser(user);
        Category category = new Category(1L,"test");
        BigDecimal amount = new BigDecimal("100.50");
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.now());
        transaction.setAmount(amount);
        transaction.setCategoryId(category.getId());
        transaction.setUserId(user.getId());

        assertEquals(transaction , transactionService.createTransaction(transaction));


    }
}