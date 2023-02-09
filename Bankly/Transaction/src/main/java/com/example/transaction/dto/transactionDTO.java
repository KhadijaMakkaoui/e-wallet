package com.example.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class transactionDTO {
    public Long id;
    public String ref;
    public float amount;
    public String wallet;
    public String type;


}
