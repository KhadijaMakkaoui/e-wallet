package com.example.transaction;

import com.example.transaction.dto.walletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "APIWallet", url = "http://localhost:8082")
public interface APIWallet {
    @GetMapping("/api/v1/wallet/{id_user}/{amount}")
    public walletDto checkBallance(@PathVariable("id_user") String ref, @PathVariable("amount") float amount);
}
