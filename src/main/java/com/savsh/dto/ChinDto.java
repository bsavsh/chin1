package com.savsh.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savsh.entity.Chinchilla;
import com.savsh.entity.Gender;

import java.time.LocalDate;

public class ChinDto {
    private Long id;
    private Gender gender;
    private String color;
    private long fatherId;
    private long motherId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate born;
    private Boolean deceased;
    private String description;

    public ChinDto() {
    }

    public ChinDto(Chinchilla chin) {
        setId(chin.getId());
        setGender(chin.getGender());
        setColor(chin.getColor());
        setFatherId(chin.getFather() == null ? 0 : chin.getFather().getId());
        setMotherId(chin.getMother() == null ? 0 : chin.getMother().getId());
        setBorn(chin.getBorn());
        setDeceased(chin.getDeceased());
        setDescription(chin.getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getFatherId() {
        return fatherId;
    }

    public void setFatherId(long fatherId) {
        this.fatherId = fatherId;
    }

    public long getMotherId() {
        return motherId;
    }

    public void setMotherId(long motherId) {
        this.motherId = motherId;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public Boolean getDeceased() {
        return deceased;
    }

    public void setDeceased(Boolean deceased) {
        this.deceased = deceased;
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

        ChinDto chinDto = (ChinDto) o;

        if (fatherId != chinDto.fatherId) return false;
        if (motherId != chinDto.motherId) return false;
        if (!id.equals(chinDto.id)) return false;
        if (gender != chinDto.gender) return false;
        if (!color.equals(chinDto.color)) return false;
        if (born != null ? !born.equals(chinDto.born) : chinDto.born != null) return false;
        if (deceased != null ? !deceased.equals(chinDto.deceased) : chinDto.deceased != null) return false;
        return description != null ? description.equals(chinDto.description) : chinDto.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (int) (fatherId ^ (fatherId >>> 32));
        result = 31 * result + (int) (motherId ^ (motherId >>> 32));
        result = 31 * result + (born != null ? born.hashCode() : 0);
        result = 31 * result + (deceased != null ? deceased.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
