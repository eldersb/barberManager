package com.elderborges.barberManager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Long id;
    private String nameClient;
    private String nameBarber;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date date;

}
