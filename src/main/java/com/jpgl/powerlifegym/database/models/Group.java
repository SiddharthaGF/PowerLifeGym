package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "`groups`")
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_instructor")
    private int idInstructor;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "id_instructor", referencedColumnName = "id", nullable = true, insertable = false, updatable = false)
    private Instructor instructorsByIdInstructor;
    @JsonBackReference
    @OneToMany(mappedBy = "groupsByIdGroup")
    private Collection<Inscription> inscriptionsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Group group = (Group) o;

        if (id != group.id) return false;
        if (idInstructor != group.idInstructor) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        if (createdAt != null ? !createdAt.equals(group.createdAt) : group.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(group.updatedAt) : group.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idInstructor;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Instructor getInstructorsByIdInstructor() {
        return instructorsByIdInstructor;
    }

    public void setInstructorsByIdInstructor(Instructor instructorsByIdInstructor) {
        this.instructorsByIdInstructor = instructorsByIdInstructor;
    }

    public Collection<Inscription> getInscriptionsById() {
        return inscriptionsById;
    }

    public void setInscriptionsById(Collection<Inscription> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }
}
