package com.example.transaction.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String ref;

    private float amount;
    @NotEmpty
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long user_id;

}
