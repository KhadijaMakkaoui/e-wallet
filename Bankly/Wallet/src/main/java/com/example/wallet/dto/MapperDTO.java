package com.example.wallet.dto;

import com.example.wallet.entity.Wallet;
import org.springframework.stereotype.Component;

@Component
public class MapperDTO {
    public WalletDTO mapToDTO(Wallet wallet) {
        Long id = wallet.getId();
        String ref = wallet.getRef();
        float balance = wallet.getBalance();
        Long user_id = wallet.getUserId();

        return new WalletDTO(id, ref, balance, user_id);
    }

}
