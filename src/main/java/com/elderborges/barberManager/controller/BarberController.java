package com.elderborges.barberManager.controller;

import com.elderborges.barberManager.services.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarberController {
    @Autowired
    private BarberService barberService;

    @GetMapping("/barbers")
    public String showBarbers(Model model) {
        model.addAttribute("barbers", barberService.getAllBarbers());
        return "barbers";
    }
}
