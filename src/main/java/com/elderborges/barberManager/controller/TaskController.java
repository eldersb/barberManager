package com.elderborges.barberManager.controller;

import com.elderborges.barberManager.entities.Task;
import com.elderborges.barberManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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



}
