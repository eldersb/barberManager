package com.elderborges.barberManager.repository;

import com.elderborges.barberManager.entities.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BarberRepository extends JpaRepository<Barber, Long> {
}
