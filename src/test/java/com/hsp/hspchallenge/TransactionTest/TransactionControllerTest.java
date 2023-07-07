package com.hsp.hspchallenge.TransactionTest;

import com.hsp.hspchallenge.controller.TransactionController;
import com.hsp.hspchallenge.model.Category;
import com.hsp.hspchallenge.model.Transaction;
import com.hsp.hspchallenge.model.User;
import com.hsp.hspchallenge.service.TransactionService;
import com.hsp.hspchallenge.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TransactionControllerTest {

    @Autowired
    private TransactionController transactionController;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;




    @Test
    void ItShouldReturnCreatedTransaction() {
        //creating user category and transaction
        User user = new User(1L,"test","test","test",new BigDecimal("1000.00"));
        userService.createUser(user);
        Category category = new Category(1L,"test");
        BigDecimal amount = new BigDecimal("100.50");
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.now());
        transaction.setAmount(amount);
        transaction.setCategoryId(category.getId());
        transaction.setUserId(user.getId());

        //testing
        assertEquals(user.getId() , transaction.getUserId());
        ResponseEntity<Transaction> response = transactionController.createTransaction(transaction);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(transaction, response.getBody());
    }


    @Test
    void ItShouldDeleteTransaction() {
        //creating user category and transaction
        User user = new User(1L,"test","test","test",new BigDecimal("1000.00"));
        userService.createUser(user);
        Category category = new Category(1L,"test");
        BigDecimal amount = new BigDecimal("100.50");
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.now());
        transaction.setAmount(amount);
        transaction.setCategoryId(category.getId());
        transaction.setUserId(user.getId());
        transactionService.createTransaction(transaction);

        //testing
        assertEquals(user.getId() , transaction.getUserId());
        ResponseEntity<Void> response = transactionController.deleteTransaction(transaction.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}