package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cellphone_numbers", schema = "powerlifegymdb", catalog = "")
public class CellphoneNumber {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_person")
    private int idPerson;
    @Basic
    @Column(name = "number")
    private String number;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Person peopleByIdPerson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CellphoneNumber that = (CellphoneNumber) o;

        if (id != that.id) return false;
        if (idPerson != that.idPerson) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPerson;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Person getPeopleByIdPerson() {
        return peopleByIdPerson;
    }

    public void setPeopleByIdPerson(Person peopleByIdPerson) {
        this.peopleByIdPerson = peopleByIdPerson;
    }
}
