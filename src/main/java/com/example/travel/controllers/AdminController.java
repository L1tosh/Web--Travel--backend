package com.example.travel.controllers;

import com.example.travel.models.Question;
import com.example.travel.models.Travel;
import com.example.travel.services.QuestionService;
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
    private final QuestionService questionService;

    @GetMapping("/admin")
    public String admin(@RequestParam(name = "title", required = false) String title, Model model) {
        return "admin/admin";
    }
    @GetMapping("/admin/travel")
    public String adminTravel(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("travels", travelService.listTravel(title));
        return "admin/admin-travel";
    }
    @PostMapping("/admin/travel/create")
    public String createTravel(Travel travel) {
        travelService.saveTravel(travel);
        return "redirect:/admin/travel";
    }
    @PostMapping("/admin/travel/delete/{id}")
    public String deleteTravel(@PathVariable long id) {
        travelService.deleteTravel(id);
        return "redirect:/admin/travel";
    }
    @GetMapping("/admin/travel/edit/{id}")
    public String editTravel(@PathVariable long id, Model model) throws IOException {
        model.addAttribute("travel", travelService.getTravelById(id));
        return "admin/edit-travel";
    }
    @PostMapping("/admin/travel/edit/{id}")
    public String updateTravel(@PathVariable(value = "id") long id, Travel travel) {
        travelService.editTravel(id, travel);
        return "redirect:/admin/travel";
    }

    @GetMapping("/admin/question")
    public String adminQuestion(Model model) {
        model.addAttribute("listQuestionCategory", questionService.getListQuestionCategory());
        model.addAttribute("listQuestion", questionService.getListQuestion());
        return "admin/question";
    }
    @PostMapping("/admin/question/create")
    public String createQuestion(@RequestParam("question") String question,
                                 @RequestParam("answer") String answer,
                                 @RequestParam("category") String category) {
        questionService.saveQuestion(question, category, answer);
        return "redirect:/admin/question";
    }
    @PostMapping("/admin/question/delete/{id}")
    public String deleteQuestion(@PathVariable long id) {
        questionService.deleteQuestion(id);
        return "redirect:/admin/question";
    }
    @GetMapping("/admin/question/edit/{id}")
    public String editQuestion(@PathVariable long id, Model model) {
        model.addAttribute("question", questionService.getQuestionById(id));
        model.addAttribute("listQuestionCategory", questionService.getListQuestionCategory());
        return "admin/edit-question";
    }
    @PostMapping("/admin/question/edit/{id}")
    public String updateQuestion(@PathVariable(value = "id") long id, @RequestParam("question") String question,
                                 @RequestParam("answer") String answer,
                                 @RequestParam("category") String category) {
        questionService.editQuestion(id, question, category, answer);
        return "redirect:/admin/question";
    }

}
