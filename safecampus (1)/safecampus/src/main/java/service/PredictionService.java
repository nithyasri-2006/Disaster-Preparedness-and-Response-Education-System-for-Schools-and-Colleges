package com.safecampus.safecampus.service;

import com.safecampus.safecampus.model.DisasterAlert;
import com.safecampus.safecampus.repository.DisasterRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PredictionService {

    private final DisasterRepository repo;

    public PredictionService(DisasterRepository repo) {
        this.repo = repo;
    }

    public Map<String, Integer> getRiskZones() {

        List<DisasterAlert> list = repo.findAll();
        Map<String, Integer> map = new HashMap<>();

        for (DisasterAlert d : list) {
            map.put(d.getLocation(),
                    map.getOrDefault(d.getLocation(), 0) + 1);
        }

        return map;
    }
}