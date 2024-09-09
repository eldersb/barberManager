package com.elderborges.barberManager.services;

import com.elderborges.barberManager.entities.Task;
import com.elderborges.barberManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task inserir(Task task) {
        taskRepository.save(task);
        return task;
    }

}
