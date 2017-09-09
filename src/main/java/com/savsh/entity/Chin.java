package com.savsh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Chin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4, max = 6, message="error.sex.size")
    private String sex;

    @NotNull
    @Size(min = 2, max = 20, message = "error.color.size")
    private String color;

    @Min(value = 1, message = "error.notnumber")
    private Long fatherId;

    @Min(value = 1, message = "error.notnumber")
    private Long motherId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate born;

    private Boolean deceased;

    private Boolean sold;

    private Boolean inFamily;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public Long getMotherId() {
        return motherId;
    }

    public void setMotherId(Long motherId) {
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

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public Boolean getInFamily() {
        return inFamily;
    }

    public void setInFamily(Boolean inFamily) {
        this.inFamily = inFamily;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chin chin = (Chin) o;

        return id != null ? id.equals(chin.id) : chin.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Chin{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", color='" + color + '\'' +
                ", fatherId=" + fatherId +
                ", motherId=" + motherId +
                ", born=" + born +
                ", deceased=" + deceased +
                ", sold=" + sold +
                ", inFamily=" + inFamily +
                ", name='" + name + '\'' +
                '}';
    }
}
