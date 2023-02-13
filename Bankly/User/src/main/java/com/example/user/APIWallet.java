package com.example.user;

import com.example.user.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "APIWalle", url = "http://localhost:8082")
public interface APIWallet {
    @PostMapping("/api/v1/wallet")
    public WalletDto createWallet(@RequestBody WalletDto walletDto);
}
