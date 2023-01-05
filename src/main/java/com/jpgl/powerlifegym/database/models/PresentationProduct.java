package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "presentations")
public class PresentationProduct {
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
    @JsonIgnore
    @OneToMany(mappedBy = "presentationsByIdPresentation")
    private Collection<Supplement> supplementsById;

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
        if (o == null || getClass () != o.getClass ()) return false;
        PresentationProduct that = (PresentationProduct) o;
        return id == that.id && Objects.equals (name, that.name) && Objects.equals (description, that.description) && Objects.equals (createdAt, that.createdAt) && Objects.equals (updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, name, description, createdAt, updatedAt);
    }

    public Collection<Supplement> getSupplementsById() {
        return supplementsById;
    }

    public void setSupplementsById(Collection<Supplement> supplementsById) {
        this.supplementsById = supplementsById;
    }
}
