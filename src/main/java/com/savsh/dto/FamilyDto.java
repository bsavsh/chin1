package com.savsh.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savsh.entity.Chinchilla;
import com.savsh.entity.Family;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FamilyDto {
    private Long id;
    private long number;
    private long husband;
    private long wife;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfFormation;
    private String description;

    public FamilyDto() {
    }

    public FamilyDto(Family family) {
        setId(family.getId());
        setNumber(family.getNumber());
        setHusband(family.getHusband().getId());
        setWife(family.getWife().getId());
        setDateOfFormation(family.getDateOfFormation());
        setDescription(family.getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getHusband() {
        return husband;
    }

    public void setHusband(long husband) {
        this.husband = husband;
    }

    public long getWife() {
        return wife;
    }

    public void setWife(long wife) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyDto familyDto = (FamilyDto) o;

        if (number != familyDto.number) return false;
        if (husband != familyDto.husband) return false;
        if (wife != familyDto.wife) return false;
        if (!id.equals(familyDto.id)) return false;
        if (dateOfFormation != null ? !dateOfFormation.equals(familyDto.dateOfFormation) : familyDto.dateOfFormation != null)
            return false;
        return description != null ? description.equals(familyDto.description) : familyDto.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (husband ^ (husband >>> 32));
        result = 31 * result + (int) (wife ^ (wife >>> 32));
        result = 31 * result + (dateOfFormation != null ? dateOfFormation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
