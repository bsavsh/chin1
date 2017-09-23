package com.savsh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class  Chinchilla {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Size(min = 2, max = 20, message = "error.color.size")
    private String color;

    @ManyToOne
    private Chinchilla father;

    @ManyToOne
    private Chinchilla mother;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate born;

    private Boolean deceased;

    private String description;

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

    public Chinchilla getFather() {
        return father;
    }

    public void setFather(Chinchilla father) {
        this.father = father;
    }

    public Chinchilla getMother() {
        return mother;
    }

    public void setMother(Chinchilla mother) {
        this.mother = mother;
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

        Chinchilla that = (Chinchilla) o;

        if (!id.equals(that.id)) return false;
        if (gender != that.gender) return false;
        if (!color.equals(that.color)) return false;
        if (father != null ? !father.equals(that.father) : that.father != null) return false;
        if (mother != null ? !mother.equals(that.mother) : that.mother != null) return false;
        if (born != null ? !born.equals(that.born) : that.born != null) return false;
        if (deceased != null ? !deceased.equals(that.deceased) : that.deceased != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (father != null ? father.hashCode() : 0);
        result = 31 * result + (mother != null ? mother.hashCode() : 0);
        result = 31 * result + (born != null ? born.hashCode() : 0);
        result = 31 * result + (deceased != null ? deceased.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
