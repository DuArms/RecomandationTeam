package com.ipproject.recommendation.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Illness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;

    @ElementCollection
    private List<String> symptoms;

    @ElementCollection
    private List<String> complications;

    @ElementCollection
    private List<String> medication;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public List<String> getComplications() {
        return complications;
    }

    public void setComplications(List<String> complications) {
        this.complications = complications;
    }

    public List<String> getMedication() {
        return medication;
    }

    public void setMedication(List<String> medication) {
        this.medication = medication;
    }
}
