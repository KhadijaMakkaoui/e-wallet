package com.example.transaction;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/v1/transaction")
public class transactionController {
    @Autowired
    private transactionService transactionService;

    @GetMapping
    public List<transactionDTO> ListTransactions() {
        return transactionService.getAll();
    }
    @PostMapping("/credit")
    @ResponseStatus(HttpStatus.CREATED)
    //fallback executed when failure
    @CircuitBreaker(name="transaction-circuitbreaker", fallbackMethod = "fallback")
    public void CreditTransaction(@RequestBody transaction transaction) {
        transactionService.TransactionOperation(transaction);
    }

    public String fallback(transaction transaction, RuntimeException e) {
        return "Sorry,something went wrong. Please try again later";
    }
}
