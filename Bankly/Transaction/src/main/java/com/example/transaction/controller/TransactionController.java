package com.example.transaction.controller;

import com.example.transaction.dto.transactionDTO;
import com.example.transaction.entity.transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class transactionController {
    @Autowired
    private com.example.transaction.service.transactionService transactionService;

    @GetMapping
    public List<transactionDTO> ListTransactions() {
        return transactionService.getAll();
    }
    /*@PostMapping("/credit")*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public transactionDTO TransactionOperation(@RequestBody transaction transaction) {
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
