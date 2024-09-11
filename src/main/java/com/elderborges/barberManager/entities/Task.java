package com.elderborges.barberManager.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameClient;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date date;

}
