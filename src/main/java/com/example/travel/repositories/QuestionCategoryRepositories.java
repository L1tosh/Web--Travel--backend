package com.example.travel.repositories;

import com.example.travel.models.QuestionCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionCategoryRepositories extends CrudRepository<QuestionCategory, Long> {
    QuestionCategory findByName(String name);
}
