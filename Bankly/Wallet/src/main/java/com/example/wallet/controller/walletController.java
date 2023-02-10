package com.example.wallet.controller;

import com.example.wallet.dto.walletDTO;
import com.example.wallet.entity.wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/{id_user}")
    public walletDTO createWallet( @PathVariable Long id_user) {
        return walletService.createWallet( id_user);
    }


}
