package com.safecampus.safecampus.repository;

import com.safecampus.safecampus.model.DisasterAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisasterRepository extends JpaRepository<DisasterAlert, Integer> {
}