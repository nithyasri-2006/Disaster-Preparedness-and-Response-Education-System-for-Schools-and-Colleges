package com.safecampus.safecampus.controller;

import com.safecampus.safecampus.model.DisasterAlert;
import com.safecampus.safecampus.service.DisasterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disaster")
public class DisasterController {

    private final DisasterService service;

    public DisasterController(DisasterService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<DisasterAlert> getAll() {
        return service.getAllDisasters();
    }

    @PostMapping("/report")
    public DisasterAlert report(@RequestBody DisasterAlert d) {
        return service.saveDisaster(d);
    }

    @PutMapping("/resolve/{id}")
    public String resolve(@PathVariable int id) {
        return service.resolve(id);
    }
}