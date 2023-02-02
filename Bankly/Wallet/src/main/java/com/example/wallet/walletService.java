package com.example.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class walletService {
    @Autowired
    private walletRepository walletRepository;
    public List<wallet> getAll() {
        return walletRepository.findAll();
    }
}
