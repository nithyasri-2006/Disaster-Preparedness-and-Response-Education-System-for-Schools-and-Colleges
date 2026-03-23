package com.safecampus.safecampus.model;

import jakarta.persistence.*;

@Entity
public class Disaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String location;
    private String safetyInstructions;

    // Getters and Setters
}