package com.example.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/v1/transaction")
public class transactionController {
    @Autowired
    private transactionService transactionService;
    @Autowired
    private MapperDTO mapper;
    @GetMapping
    public List<transactionDTO> ListTransactions() {
        return transactionService.getAll()
                .stream()
                .map((transaction) -> mapper.mapToDTO(transaction))
                .collect(toList());
    }
}
