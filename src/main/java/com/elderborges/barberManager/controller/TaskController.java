package com.elderborges.barberManager.controller;

import com.elderborges.barberManager.entities.Task;
import com.elderborges.barberManager.services.BarberService;
import com.elderborges.barberManager.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private BarberService barberService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("barbers", barberService.getAllBarbers());

        return "index";
    }

    @PostMapping("/home")
    public String create( @ModelAttribute Task task) {
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
            model.addAttribute("barbers", barberService.getAllBarbers());

        } else {
            return "redirect:/list";
        }

        return "update";
    }

    @PutMapping("/update/{id}")
    public String update(@ModelAttribute Task task, @PathVariable Long id) {
        Optional<Task> taskOptional = taskService.findTaskId(id);

        taskService.update(id, task);

        return "redirect:/list";

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Optional<Task> taskDelete = taskService.findTaskId(id);

        if (taskDelete.isPresent()) {
            taskService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Task deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Task not found!");
        }
        return "redirect:/list";
    }

//    @GetMapping("/barbers")
//    public String showBarbers(Model model) {
//
//        return "barbers";
//    }


}
