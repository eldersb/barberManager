package com.elderborges.barberManager.controller;

import com.elderborges.barberManager.entities.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ServiceController {


    List<Task> tasks = new ArrayList<>();

    @GetMapping("/create")
    public String home() {
        return "create";
    }

    @PostMapping("/create")
    public String create(Task task) {
        Long id =  tasks.size() + 1L;
        tasks.add(new Task(id, task.getNameClient(), task.getNameBarber(), task.getDate()));

        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("tasks", tasks);
        return mv;
    }

}
