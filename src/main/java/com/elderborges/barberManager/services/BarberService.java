package com.elderborges.barberManager.services;

import com.elderborges.barberManager.entities.Barber;
import com.elderborges.barberManager.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {
    @Autowired
    private BarberRepository barberRepository;

    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }
}
