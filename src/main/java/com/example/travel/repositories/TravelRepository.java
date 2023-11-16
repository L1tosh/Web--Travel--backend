package com.example.travel.repositories;

import com.example.travel.models.Travel;
import org.springframework.data.repository.CrudRepository;

public interface TravelRepository extends CrudRepository<Travel, Long> {
}
