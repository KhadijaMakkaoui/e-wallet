package com.example.wallet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class wallet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String ref;
    private float balance;
    private String owner;
}
