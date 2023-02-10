package com.example.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "APIWallet", url = "http://localhost:8082/api/v1/wallet")
public interface APIUser {
    @PostMapping("{id_user}")
    public void createWallet(@PathVariable Long id_user);
}
