package com.savsh.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savsh.entity.Chinchilla;
import com.savsh.entity.SellChin;

import java.time.LocalDate;

public class FinanceRowDto {
    private Long id;
    private Long chinchilla;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfSelling;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfMoneyBack;
    private String description;

    public FinanceRowDto() {
    }

    public FinanceRowDto(SellChin chin) {
        setId(chin.getId());
        setChinchilla(chin.getChinchilla().getId());
        setDateOfSelling(chin.getDateOfSelling());
        setDateOfMoneyBack(chin.getDateOfMoneyBack());
        setDescription(chin.getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChinchilla() {
        return chinchilla;
    }

    public void setChinchilla(Long chinchilla) {
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
