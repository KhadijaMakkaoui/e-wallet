package com.example.user;

import com.example.user.dto.WalletDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@FeignClient(name = "APIWalletUser", url = "http://localhost:8082")
public interface APIUser {
    @PostMapping("/api/v1/wallet/{id_user}")
    public WalletDto createWallet(@PathVariable("id_user") Long id_user);
}
