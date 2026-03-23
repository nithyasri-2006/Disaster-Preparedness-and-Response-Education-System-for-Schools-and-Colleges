package com.safecampus.safecampus.service;

import com.safecampus.safecampus.model.DisasterAlert;
import com.safecampus.safecampus.repository.DisasterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisasterService {

    private final DisasterRepository repository;

    public DisasterService(DisasterRepository repository) {
        this.repository = repository;
    }

    public List<DisasterAlert> getAllDisasters() {
        return repository.findAll();
    }

    public DisasterAlert saveDisaster(DisasterAlert d) {
        d.setStatus("Pending");
        return repository.save(d);
    }

    public String resolve(int id) {
        DisasterAlert d = repository.findById(id).orElse(null);
        if (d != null) {
            d.setStatus("Resolved");
            repository.save(d);
            return "Resolved";
        }
        return "Not Found";
    }
}