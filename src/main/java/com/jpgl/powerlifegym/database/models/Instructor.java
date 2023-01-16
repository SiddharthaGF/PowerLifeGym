package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "instructors")
@PrimaryKeyJoinColumn ( name = "id_person")
public class Instructor extends Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_person", insertable = false, updatable = false)
    private Integer idPerson;
    @Basic
    @Column(name = "id_specialization")
    private Integer idSpecialization;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "instructorsByIdInstructor")
    private Collection<Group> groupsById;
    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", insertable = false, updatable = false)
    private Person peopleByIdPerson;
    @ManyToOne
    @JoinColumn(name = "id_specialization", referencedColumnName = "id", insertable = false, updatable = false)
    private Specialization specializationsByIdSpecialization;

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

    public Integer getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(Integer idSpecialization) {
        this.idSpecialization = idSpecialization;
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

        Instructor that = (Instructor) o;

        if (id != that.id) return false;
        if (idPerson != null ? !idPerson.equals(that.idPerson) : that.idPerson != null) return false;
        if (idSpecialization != null ? !idSpecialization.equals(that.idSpecialization) : that.idSpecialization != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idPerson != null ? idPerson.hashCode() : 0);
        result = 31 * result + (idSpecialization != null ? idSpecialization.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<Group> getGroupsById() {
        return groupsById;
    }

    public void setGroupsById(Collection<Group> groupsById) {
        this.groupsById = groupsById;
    }

    public Person getPeopleByIdPerson() {
        return peopleByIdPerson;
    }

    public void setPeopleByIdPerson(Person peopleByIdPerson) {
        this.peopleByIdPerson = peopleByIdPerson;
    }

    public Specialization getSpecializationsByIdSpecialization() {
        return specializationsByIdSpecialization;
    }

    public void setSpecializationsByIdSpecialization(Specialization specializationsByIdSpecialization) {
        this.specializationsByIdSpecialization = specializationsByIdSpecialization;
    }
}
