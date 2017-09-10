package com.savsh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long chinId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfChinGone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfMoneyBack;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChinId() {
        return chinId;
    }

    public void setChinId(Long chinId) {
        this.chinId = chinId;
    }

    public LocalDate getDateOfChinGone() {
        return dateOfChinGone;
    }

    public void setDateOfChinGone(LocalDate dateOfChinGone) {
        this.dateOfChinGone = dateOfChinGone;
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

        Finance finance = (Finance) o;

        return id != null ? id.equals(finance.id) : finance.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Finance{" +
                "id=" + id +
                ", chinId=" + chinId +
                ", dateOfChinGone=" + dateOfChinGone +
                ", dateOfMoneyBack=" + dateOfMoneyBack +
                ", description='" + description + '\'' +
                '}';
    }
}
