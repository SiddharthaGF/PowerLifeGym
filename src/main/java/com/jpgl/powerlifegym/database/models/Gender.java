package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "genders", schema = "powerlifegymdb", catalog = "")
public class Gender {
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
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "gendersByIdGender")
    private Collection<Cloth> clothesById;
    @OneToMany(mappedBy = "gendersByIdGender")
    private Collection<Person> peopleById;

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

        Gender gender = (Gender) o;

        if (id != gender.id) return false;
        if (name != null ? !name.equals(gender.name) : gender.name != null) return false;
        if (description != null ? !description.equals(gender.description) : gender.description != null) return false;
        if (createdAt != null ? !createdAt.equals(gender.createdAt) : gender.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(gender.updatedAt) : gender.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<Cloth> getClothesById() {
        return clothesById;
    }

    public void setClothesById(Collection<Cloth> clothesById) {
        this.clothesById = clothesById;
    }

    public Collection<Person> getPeopleById() {
        return peopleById;
    }

    public void setPeopleById(Collection<Person> peopleById) {
        this.peopleById = peopleById;
    }
}
