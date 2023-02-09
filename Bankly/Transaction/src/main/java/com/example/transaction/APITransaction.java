package com.example.transaction;

import com.example.transaction.dto.walletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "APIWallet", url = "http://localhost:8082")
public interface APITransaction {
    @GetMapping("/api/v1/wallet/{ref}/{amount}")
    public walletDto checkBallance(@PathVariable("ref") String ref, @PathVariable("amount") float amount);
}
