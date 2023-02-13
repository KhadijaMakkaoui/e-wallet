package com.example.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class walletDto {
    private String ref;
    private float balance;
    private String type;
    private Long user_id;
}
