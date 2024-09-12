package com.elderborges.barberManager.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nameClient;

    private String telephone;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime date;


}
