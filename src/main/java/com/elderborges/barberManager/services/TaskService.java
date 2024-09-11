package com.elderborges.barberManager.services;

import com.elderborges.barberManager.entities.Barber;
import com.elderborges.barberManager.entities.Task;
import com.elderborges.barberManager.repository.BarberRepository;
import com.elderborges.barberManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    BarberRepository barberRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task inserir(Task task) {
        taskRepository.save(task);
        return task;
    }

    public Task update(Long id, Task task) {
        Optional<Task> taskOptional = findTaskId(id);

        if (taskOptional.isPresent()) {
           Task newTask = taskOptional.get();
            newTask.setNameClient(task.getNameClient());
            newTask.setBarber(task.getBarber());
            newTask.setDate(task.getDate());

            return taskRepository.save(newTask);

        }

        return null;
    }

    public void remove(Long id) {
        Optional<Task> task = findTaskId(id);

        if (task.isPresent()){
            taskRepository.delete(task.get());
        }
    }


    public Optional<Task> findTaskId(Long id) {
        return taskRepository.findById(id);
    }

    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

}
