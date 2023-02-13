package com.example.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class transactionDTO {
    public Long id;
    public String ref;
    public float amount;
    public String type;
    public Date date;
    public Long wallet_id;


}
