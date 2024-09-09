package com.elderborges.barberManager.controller;

import com.elderborges.barberManager.entities.Task;
import com.elderborges.barberManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/create")
    public String home(Model model) {
        model.addAttribute("task", new Task());

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Task task) {
        taskService.inserir(task);
        return "redirect:/list";

    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Task> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        return "list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Optional<Task> taskOptional = taskService.findTaskId(id);
        if (taskOptional.isPresent()) {
            model.addAttribute("task", taskOptional.get());
        } else {
            // Lidar com o caso em que a tarefa não é encontrada, talvez redirecionar para uma página de erro
            return "redirect:/list";
        }

        return "update";
    }

    @PutMapping("/update/{id}")
    public String update(@ModelAttribute Task newTask, @PathVariable Long id) {
        Optional<Task> taskOptional = taskService.findTaskId(id);

        taskService.update(id, newTask);

        return "redirect:/list";

    }



}
