package com.example.travel.services;

import com.example.travel.models.Travel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelService {
    private List<Travel> travels = new ArrayList<>();

    public List<Travel> list() {
        return travels;
    }
    public void saveTravel(Travel travel) {
        travels.add(travel);
    }
    public void deleteProduct(Long id) {
        travels.removeIf(travel -> travel.getId().equals(id));
    }

}
