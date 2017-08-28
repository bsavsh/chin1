package com.savsh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.sql.Timestamp;

@Entity
public class Chin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4, max = 6, message="sex must be between 4 and 6 characters long.")
    private String sex;

    @NotNull
    @Size(min = 2, max = 20, message = "color must be between 2 and 20 characters long.")
    private String color;

    @Digits(integer = 100, fraction = 0, message = "father id must be an integer number")
    @Min(1)
    private Long fatherId;


    @Digits(integer = 100, fraction = 0, message = "mother id must be an integer number")
    @Min(1)
    private Long motherId;

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

        if (!id.equals(chin.id)) return false;
        if (sex != null ? !sex.equals(chin.sex) : chin.sex != null) return false;
        if (color != null ? !color.equals(chin.color) : chin.color != null) return false;
        if (fatherId != null ? !fatherId.equals(chin.fatherId) : chin.fatherId != null) return false;
        return motherId != null ? motherId.equals(chin.motherId) : chin.motherId == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
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
                ", fatherId=" + fatherId +
                ", motherId=" + motherId +
                '}';
    }
}
