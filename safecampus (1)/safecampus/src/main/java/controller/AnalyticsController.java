package com.safecampus.safecampus.controller;

import com.safecampus.safecampus.model.DisasterAlert;
import com.safecampus.safecampus.repository.DisasterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final DisasterRepository repo;

    public AnalyticsController(DisasterRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/types")
    public Map<String, Integer> getTypes() {

        List<DisasterAlert> list = repo.findAll();
        Map<String, Integer> map = new HashMap<>();

        for (DisasterAlert d : list) {
            map.put(d.getDisasterType(),
                    map.getOrDefault(d.getDisasterType(), 0) + 1);
        }

        return map;
    }
}