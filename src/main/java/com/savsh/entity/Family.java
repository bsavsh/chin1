package com.savsh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long husbandId;

    private Long wifeId;

    private Long numberOfFamily;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfFormation;

    @Size(min = 2, max = 30, message = "error.family.description.size")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHusbandId() {
        return husbandId;
    }

    public void setHusbandId(Long husbandId) {
        this.husbandId = husbandId;
    }

    public Long getWifeId() {
        return wifeId;
    }

    public void setWifeId(Long wifeId) {
        this.wifeId = wifeId;
    }

    public Long getNumberOfFamily() {
        return numberOfFamily;
    }

    public void setNumberOfFamily(Long numberOfFamily) {
        this.numberOfFamily = numberOfFamily;
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

        Family family = (Family) o;

        if (id != null ? !id.equals(family.id) : family.id != null) return false;
        if (husbandId != null ? !husbandId.equals(family.husbandId) : family.husbandId != null) return false;
        if (wifeId != null ? !wifeId.equals(family.wifeId) : family.wifeId != null) return false;
        if (numberOfFamily != null ? !numberOfFamily.equals(family.numberOfFamily) : family.numberOfFamily != null)
            return false;
        if (dateOfFormation != null ? !dateOfFormation.equals(family.dateOfFormation) : family.dateOfFormation != null)
            return false;
        return description != null ? description.equals(family.description) : family.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (husbandId != null ? husbandId.hashCode() : 0);
        result = 31 * result + (wifeId != null ? wifeId.hashCode() : 0);
        result = 31 * result + (numberOfFamily != null ? numberOfFamily.hashCode() : 0);
        result = 31 * result + (dateOfFormation != null ? dateOfFormation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", husbandId=" + husbandId +
                ", wifeId=" + wifeId +
                ", numberOfFamily=" + numberOfFamily +
                ", dateOfFormation=" + dateOfFormation +
                ", description='" + description + '\'' +
                '}';
    }
}
