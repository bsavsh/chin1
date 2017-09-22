package com.savsh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long number;

    @ManyToOne
    @NotNull
    private Chinchilla husband;

    @OneToOne
    @NotNull
    private Chinchilla wife;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfFormation;

    @NotNull(message = "error.cannot.be.empty")
    @Size(min = 1, max = 50, message = "error.cannot.be.empty")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Chinchilla getHusband() {
        return husband;
    }

    public void setHusband(Chinchilla husband) {
        this.husband = husband;
    }

    public Chinchilla getWife() {
        return wife;
    }

    public void setWife(Chinchilla wife) {
        this.wife = wife;
    }

    public LocalDate getDateOfFormation() {
        return dateOfFormation;
    }

    public void setDateOfFormation(LocalDate dateOfFormation) {
        this.dateOfFormation = dateOfFormation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
