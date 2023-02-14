package com.example.transaction.controller;

import com.example.transaction.dto.TransactionDTO;
import com.example.transaction.entity.Transaction;
import com.example.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<TransactionDTO> ListTransactions() {
        return transactionService.getAll();
    }
    /*@PostMapping("/credit")*/
    @PostMapping
    public TransactionDTO TransactionOperation(@RequestBody Transaction transaction) {
        return transactionService.TransactionOperation(transaction);
    }
    //fallback executed when failure
    /*@CircuitBreaker(name="transaction-circuitbreaker", fallbackMethod = "fallback")
    @TimeLimiter(name="transaction-circuitbreaker")
    @Retry(name="transaction-circuitbreaker")*/
  /*  public CompletableFuture<transaction> CreditTransaction(@RequestBody transaction transaction) {
        return CompletableFuture.supplyAsync(()->transactionService.TransactionOperation(transaction));
    }

    public CompletableFuture<String> fallback(transaction transaction, RuntimeException e) {
        return CompletableFuture.supplyAsync(()->"Sorry,something went wrong. Please try again later");
    }*/
}
