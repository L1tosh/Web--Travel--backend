package com.example.travel.services;

import com.example.travel.models.Question;
import com.example.travel.models.QuestionCategory;
import com.example.travel.models.Travel;
import com.example.travel.repositories.QuestionCategoryRepositories;
import com.example.travel.repositories.QuestionRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionCategoryRepositories questionCategoryRepositories;
    private final QuestionRepositories questionRepositories;


    public List<QuestionCategory> getListQuestionCategory() {
        return (List<QuestionCategory>) questionCategoryRepositories.findAll();
    }
    public List<Question> getListQuestion() {
        return (List<Question>) questionRepositories.findAll();
    }

    public void saveQuestion(String name, String category, String answer) {
        Question question = new Question();
        question.setQuestion(name);
        question.setCategory(questionCategoryRepositories.findByName(category));
        question.setAnswer(answer);
        questionRepositories.save(question);
    }

    public void editQuestion(Long id, String question, String category, String answer) {
        Question qs = getQuestionById(id);
        qs.setQuestion(question);
        qs.setCategory(questionCategoryRepositories.findByName(category));
        qs.setAnswer(answer);
        questionRepositories.save(qs);
    }
    public void deleteQuestion(Long id) {
        questionRepositories.deleteById(id);
    }
    public Question getQuestionById(Long id) {
        return questionRepositories.findById(id).orElse(null);
    }
}
