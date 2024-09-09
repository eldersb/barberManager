package com.elderborges.barberManager.services;

import com.elderborges.barberManager.entities.Task;
import com.elderborges.barberManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Task update(Long id, Task newTask) {
        Optional<Task> task = findTaskId(id);

        if (task.isPresent()) {
           Task newTaskCreated = task.get();
            newTaskCreated.setNameClient(newTask.getNameClient());
            newTaskCreated.setNameBarber(newTask.getNameClient());
            newTaskCreated.setDate(newTask.getDate());
            taskRepository.save(newTask);

            return newTask;
        }

        return null;
    }


    public Optional<Task> findTaskId(Long id) {
        return taskRepository.findById(id);
    }

}
