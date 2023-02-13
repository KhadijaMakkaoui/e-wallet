package com.example.wallet.dto;

import com.example.wallet.entity.wallet;
import org.springframework.stereotype.Component;

@Component
public class MapperDTO {
    public WalletDTO mapToDTO(wallet wallet) {
        Long id = wallet.getId();
        String ref = wallet.getRef();
        float balance = wallet.getBalance();
        Long user_id = wallet.getUser_id();

        return new WalletDTO(id, ref, balance, user_id);
    }

}
