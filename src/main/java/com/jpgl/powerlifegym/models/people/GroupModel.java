package com.jpgl.powerlifegym.models.people;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.models.offer.services.InscriptionModel;
import com.jpgl.powerlifegym.models.people.employee.InstructorModel;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "groupss")
public class GroupModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "id_instructor", nullable = false)
    private int idInstructor;
    @Basic
    @Column(name = "name", nullable = false, length = 255, unique = true)
    private String name;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_instructor", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private InstructorModel instructorsByIdInstructor;
    @JsonIgnore
    @OneToMany(mappedBy = "groupssByIdGroup")
    private Collection<InscriptionModel> inscriptionsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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

        GroupModel that = (GroupModel) o;

        if (id != that.id) return false;
        if (idInstructor != that.idInstructor) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(updatedAt, that.updatedAt)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + idInstructor;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public InstructorModel getInstructorsByIdInstructor() {
        return instructorsByIdInstructor;
    }

    public void setInstructorsByIdInstructor(InstructorModel instructorsByIdInstructor) {
        this.instructorsByIdInstructor = instructorsByIdInstructor;
    }

    public Collection<InscriptionModel> getInscriptionsById() {
        return inscriptionsById;
    }

    public void setInscriptionsById(Collection<InscriptionModel> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }
}
