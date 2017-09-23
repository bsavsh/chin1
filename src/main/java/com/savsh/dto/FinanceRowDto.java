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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinanceRowDto that = (FinanceRowDto) o;

        if (!id.equals(that.id)) return false;
        if (chinchilla != null ? !chinchilla.equals(that.chinchilla) : that.chinchilla != null) return false;
        if (dateOfSelling != null ? !dateOfSelling.equals(that.dateOfSelling) : that.dateOfSelling != null)
            return false;
        if (dateOfMoneyBack != null ? !dateOfMoneyBack.equals(that.dateOfMoneyBack) : that.dateOfMoneyBack != null)
            return false;
        return description != null ? description.equals(that.description) : that.description == null;
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
