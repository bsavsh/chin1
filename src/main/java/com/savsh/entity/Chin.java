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

    private String deceased;

    private String name;

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chin chin = (Chin) o;

        if (id != null ? !id.equals(chin.id) : chin.id != null) return false;
        if (sex != null ? !sex.equals(chin.sex) : chin.sex != null) return false;
        if (color != null ? !color.equals(chin.color) : chin.color != null) return false;
        if (name != null ? !name.equals(chin.name) : chin.name != null) return false;
        if (born != null ? !born.equals(chin.born) : chin.born != null) return false;
        if (deceased != null ? !deceased.equals(chin.born) : chin.deceased != null) return false;
        if (fatherId != null ? !fatherId.equals(chin.fatherId) : chin.fatherId != null) return false;
        return motherId != null ? motherId.equals(chin.motherId) : chin.motherId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (born != null ? born.hashCode() : 0);
        result = 31 * result + (deceased != null ? deceased.hashCode() : 0);
        result = 31 * result + (fatherId != null ? fatherId.hashCode() : 0);
        result = 31 * result + (motherId != null ? motherId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chin{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", born=" + born +
                ", deceased=" + deceased +
                ", fatherId=" + fatherId +
                ", motherId=" + motherId +
                '}';
    }
}
