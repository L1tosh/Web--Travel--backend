package com.example.travel.controllers;

import com.example.travel.models.Travel;
import com.example.travel.services.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final TravelService travelService;

    @GetMapping("/admin")
    public String admin(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("travels", travelService.listTravel(title));
        return "admin";
    }
    @PostMapping("admin/travel/create")
    public String createTravel(Travel travel) {
        travelService.saveTravel(travel);
        return "redirect:/admin";
    }
    @PostMapping("/admin/delete/{id}")
    public String deleteTravel(@PathVariable long id) {
        travelService.deleteTravel(id);
        return "redirect:/admin";
    }
    @GetMapping("/admin/edit/{id}")
    public String editTravel(@PathVariable long id, Model model) throws IOException {
        model.addAttribute("travel", travelService.getTravelById(id));
        return "edit-travel";
    }
    @PostMapping("/admin/edit/{id}")
    public String editUpdate(@PathVariable(value = "id") long id, Travel travel) {
        travelService.editTravel(id, travel);
        return "redirect:/admin";
    }

}
