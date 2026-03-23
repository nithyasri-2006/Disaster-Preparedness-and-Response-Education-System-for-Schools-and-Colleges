package com.safecampus.safecampus.controller;

import com.safecampus.safecampus.service.PredictionService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/prediction")
public class PredictionController {

    private final PredictionService service;

    public PredictionController(PredictionService service) {
        this.service = service;
    }

    @GetMapping("/risk-zones")
    public Map<String, Integer> getRisk() {
        return service.getRiskZones();
    }
}