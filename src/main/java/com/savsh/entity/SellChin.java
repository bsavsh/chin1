package com.savsh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class SellChin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellChin sellChin = (SellChin) o;

        if (!id.equals(sellChin.id)) return false;
        if (chinchilla != null ? !chinchilla.equals(sellChin.chinchilla) : sellChin.chinchilla != null) return false;
        if (dateOfSelling != null ? !dateOfSelling.equals(sellChin.dateOfSelling) : sellChin.dateOfSelling != null)
            return false;
        if (dateOfMoneyBack != null ? !dateOfMoneyBack.equals(sellChin.dateOfMoneyBack) : sellChin.dateOfMoneyBack != null)
            return false;
        return description != null ? description.equals(sellChin.description) : sellChin.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (chinchilla != null ? chinchilla.hashCode() : 0);
        result = 31 * result + (dateOfSelling != null ? dateOfSelling.hashCode() : 0);
        result = 31 * result + (dateOfMoneyBack != null ? dateOfMoneyBack.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
