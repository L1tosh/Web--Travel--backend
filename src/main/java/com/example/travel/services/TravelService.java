package com.example.travel.services;

import com.example.travel.models.Travel;
import com.example.travel.repositories.TravelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TravelService {
    private final TravelRepository travelRepository;
    public List<Travel> listTravel(String name) {
        if (name != null) travelRepository.findByName(name);
        return (List<Travel>) travelRepository.findAll();
    }
    public void saveTravel(Travel travel) {
        log.info("Saving new : {}", travel);
        travelRepository.save(travel);
    }
    public void editTravel(Long id, Travel upTravel) {
        Travel travel = getTravelById(id);

        travel.setName(upTravel.getName());
        travel.setPrice(upTravel.getPrice());
        travel.setNumber_of_people(upTravel.getNumber_of_people());
        travel.setCity(upTravel.getCity());
        travel.setCity(upTravel.getCountry());
        travel.setDay(upTravel.getDay());
        travel.setDescription(upTravel.getDescription());

        travelRepository.save(travel);
    }
    public void deleteTravel(Long id) {
        travelRepository.deleteById(id);
    }
    public Travel getTravelById(Long id) {
        return travelRepository.findById(id).orElse(null);
    }

}
