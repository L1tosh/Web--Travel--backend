package com.example.travel.repositories;

import com.example.travel.models.Travel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelRepository extends CrudRepository<Travel, Long> {
    List<Travel> findByName(String name);
}
