package com.jpgl.powerlifegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "specializations")
public class Specialization {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @JsonIgnore

    @OneToMany(mappedBy = "specializationsByIdSpecialization")
    private Collection<Instructor> instructorsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (o == null || getClass () != o.getClass ()) return false;
        Specialization that = (Specialization) o;
        return id == that.id && Objects.equals (name, that.name) && Objects.equals (description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, name, description);
    }

    public Collection<Instructor> getInstructorsById() {
        return instructorsById;
    }

    public void setInstructorsById(Collection<Instructor> instructorsById) {
        this.instructorsById = instructorsById;
    }
}
