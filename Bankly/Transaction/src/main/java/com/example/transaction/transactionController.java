package com.example.transaction;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void CreditTransaction(@RequestBody transaction transaction) {
        transactionService.TransactionOperation(transaction);
    }

}
