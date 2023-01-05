package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "`groups`")
public class Group {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_instructor")
    private Integer idInstructor;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_instructor", referencedColumnName = "id", insertable = false, updatable = false)
    private Instructor instructorsByIdInstructor;
    @JsonIgnore
    @OneToMany(mappedBy = "groupsByIdGroup")
    private Collection<Inscription> inscriptionsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
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
        if (o == null || getClass () != o.getClass ()) return false;
        Group that = (Group) o;
        return id == that.id && Objects.equals (idInstructor, that.idInstructor) && Objects.equals (name, that.name) && Objects.equals (createdAt, that.createdAt) && Objects.equals (updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, idInstructor, name, createdAt, updatedAt);
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
