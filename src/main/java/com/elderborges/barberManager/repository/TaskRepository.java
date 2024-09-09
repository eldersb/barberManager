package com.elderborges.barberManager.repository;

import com.elderborges.barberManager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
