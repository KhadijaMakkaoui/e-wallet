package com.example.transaction.dto;

import com.example.transaction.entity.transaction;
import org.springframework.stereotype.Component;

@Component
public class MapperDTO {
    public transactionDTO mapToDTO(transaction transaction) {
        Long id = transaction.getId();
        String ref = transaction.getRef();
        float amount = transaction.getAmount();
        String type = transaction.getType();

        return new transactionDTO(id, ref, amount, type);
    }

}
