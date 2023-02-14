package com.example.transaction;

import com.example.transaction.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "APIWallet", url = "http://localhost:8082")
public interface APIWallet {
    @GetMapping("/api/v1/wallet/{id_user}/{amount}")
    public WalletDto checkBallance(@PathVariable("id_user") Long idUser, @PathVariable("amount") float amount);
    @PostMapping("/api/v1/wallet/update/{id}")
    public WalletDto updateWallet(@PathVariable("id") Long idUser, @RequestBody WalletDto walletDTO) ;
}
