package com.example.travel.repositories;

import com.example.travel.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepositories extends CrudRepository<Question, Long> {
}
