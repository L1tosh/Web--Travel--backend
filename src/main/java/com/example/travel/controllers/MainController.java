package com.example.travel.controllers;

import com.example.travel.models.Travel;
import com.example.travel.repositories.TravelRepository;
import jdk.jfr.TransitionTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private TravelRepository travelRepository;
    @GetMapping("/")
    public String home(Model model) {
        Iterable<Travel> travels = travelRepository.findAll();
        model.addAttribute("travel", travels);
        return "main";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

}
