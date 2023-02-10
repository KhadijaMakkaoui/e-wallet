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
public class transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String ref;
    @NotEmpty
    @Column(columnDefinition = "default 0")
    private float amount;
    @NotEmpty
    private String type;
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

}
