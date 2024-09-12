package com.elderborges.barberManager.config;

import com.elderborges.barberManager.entities.Barber;
import com.elderborges.barberManager.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private BarberRepository barberRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            if (barberRepository.count() == 0) {
                Barber barber1 = new Barber("Marcelo");
                Barber barber2 = new Barber("Ronaldo");
                Barber barber3 = new Barber("Regivaldo");
                Barber barber4 = new Barber("Romário");
                barberRepository.save(barber1);
                barberRepository.save(barber2);
                barberRepository.save(barber3);
                barberRepository.save(barber4);
            }
        };
    }

}
