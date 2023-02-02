package com.example.wallet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class walletDTO {
    public Long id;
    public String ref;
    public float balance;
    public String owner;


}
