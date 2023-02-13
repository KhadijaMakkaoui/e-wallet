package com.example.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class wallet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String ref;
    private float balance;
    private Long user_id;
}
