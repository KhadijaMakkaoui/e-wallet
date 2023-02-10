package com.example.wallet.controller;

import com.example.wallet.dto.walletDTO;
import com.example.wallet.entity.wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/wallet")
public class walletController {
    @Autowired
    private com.example.wallet.service.walletService walletService;


    @GetMapping
    public List<walletDTO> ListWallets() {
        return walletService.getAll();

    }
    @GetMapping("/{ref}/{amount}")
    public wallet checkBallance(@PathVariable String ref, @PathVariable float amount) {
        return walletService.checkBallance(ref, amount);
    }


}
