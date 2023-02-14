package com.example.wallet.controller;

import com.example.wallet.dto.WalletDTO;
import com.example.wallet.entity.Wallet;
import com.example.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;


    @GetMapping
    public List<WalletDTO> ListWallets() {
        return walletService.getAll();

    }
    @GetMapping("/{id}")
    public WalletDTO getWallet(@PathVariable Long id) {
        return walletService.getWalletdto(id);
    }
    @GetMapping("/{idUser}/{amount}")
    public Wallet checkBallance(@PathVariable Long idUser, @PathVariable float amount) {
        return walletService.checkBallance(idUser, amount);
    }
    @PostMapping
    public WalletDTO createWallet(@RequestBody WalletDTO walletDto) {
        return walletService.createWallet( walletDto.getUserId());
    }

    @PostMapping("update/{id}")
    public WalletDTO updateWallet(@PathVariable("id") Long idUser,@RequestBody WalletDTO walletDTO) {
        return walletService.updateBalance( idUser,walletDTO);
    }

}
