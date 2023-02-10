package com.example.wallet.dto;

import com.example.wallet.entity.wallet;
import org.springframework.stereotype.Component;

@Component
public class MapperDTO {
    public walletDTO mapToDTO(wallet wallet) {
        Long id = wallet.getId();
        String ref = wallet.getRef();
        float balance = wallet.getBalance();
        String owner = wallet.getOwner();

        return new walletDTO(id, ref, balance, owner);
    }

}
