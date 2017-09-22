package com.savsh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class SellChin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Chinchilla chinchilla;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfSelling;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfMoneyBack;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chinchilla getChinchilla() {
        return chinchilla;
    }

    public void setChinchilla(Chinchilla chinchilla) {
        this.chinchilla = chinchilla;
    }

    public LocalDate getDateOfSelling() {
        return dateOfSelling;
    }

    public void setDateOfSelling(LocalDate dateOfSelling) {
        this.dateOfSelling = dateOfSelling;
    }

    public LocalDate getDateOfMoneyBack() {
        return dateOfMoneyBack;
    }

    public void setDateOfMoneyBack(LocalDate dateOfMoneyBack) {
        this.dateOfMoneyBack = dateOfMoneyBack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
