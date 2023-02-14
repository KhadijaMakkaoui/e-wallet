package com.example.transaction.dto;

import com.example.transaction.entity.Transaction;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MapperDTO {
    public TransactionDTO mapToDTO(Transaction transaction) {
        Long id = transaction.getId();
        String ref = transaction.getRef();
        float amount = transaction.getAmount();
        String type = transaction.getType();
        Date date = transaction.getDate();
        Long user_id = transaction.getUser_id();

        return new TransactionDTO(id, ref, amount, type, date, user_id);
    }

}
