package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "emails")
public class Email {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_person")
    private Integer idPerson;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", insertable = false, updatable = false)
    private Person peopleByIdPerson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (o == null || getClass () != o.getClass ()) return false;
        Email that = (Email) o;
        return id == that.id && Objects.equals (idPerson, that.idPerson) && Objects.equals (email, that.email) && Objects.equals (createdAt, that.createdAt) && Objects.equals (updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, idPerson, email, createdAt, updatedAt);
    }

    public Person getPeopleByIdPerson() {
        return peopleByIdPerson;
    }

    public void setPeopleByIdPerson(Person peopleByIdPerson) {
        this.peopleByIdPerson = peopleByIdPerson;
    }
}
