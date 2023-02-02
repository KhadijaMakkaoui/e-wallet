package com.example.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class transactionService {
    @Autowired
    private transactionRepository transactionRepository;
    public List<transaction> getAll() {
        return transactionRepository.findAll();
    }
}
