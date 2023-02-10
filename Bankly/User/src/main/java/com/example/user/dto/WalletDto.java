package com.example.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WalletDto {
    private Long id;
    private String ref;
    private float balance;



}
