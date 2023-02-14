package com.example.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDTO {
    public Long id;
    public String ref;
    public float amount;
    public String type;
    public Date date;
    public Long user_id;


}
