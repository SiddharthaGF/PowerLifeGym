package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "instructors", schema = "prueba", catalog = "")
public class InstructorModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;
    @Basic
    @Column(name = "created_at", nullable = true, insertable=false, updatable=false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "dni", nullable = false, length = 10)
    private String dni;
    @Basic
    @Column(name = "id_gender", nullable = false)
    private int idGender;
    @Basic
    @Column(name = "id_specialization", nullable = false)
    private int idSpecialization;
    @Basic
    @Column(name = "lastname", nullable = false, length = 255)
    private String lastname;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "updated_at", nullable = true, insertable=false, updatable=false)
    private Timestamp updatedAt;
    @JsonIgnore
    @OneToMany(mappedBy = "instructorsByIdInstructor")
    private Collection<GroupModel> groupssesById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_gender", referencedColumnName = "id", insertable=false, updatable=false)
    private GenderModel gendersByIdGender;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_specialization", referencedColumnName = "id", insertable=false, updatable=false)
    private SpecializationModel specializationsByIdSpecialization;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public int getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(int idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

        InstructorModel that = (InstructorModel) o;

        if (id != that.id) return false;
        if (idGender != that.idGender) return false;
        if (idSpecialization != that.idSpecialization) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + idGender;
        result = 31 * result + idSpecialization;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<GroupModel> getGroupssesById() {
        return groupssesById;
    }

    public void setGroupssesById(Collection<GroupModel> groupssesById) {
        this.groupssesById = groupssesById;
    }

    public GenderModel getGendersByIdGender() {
        return gendersByIdGender;
    }

    public void setGendersByIdGender(GenderModel gendersByIdGender) {
        this.gendersByIdGender = gendersByIdGender;
    }

    public SpecializationModel getSpecializationsByIdSpecialization() {
        return specializationsByIdSpecialization;
    }

    public void setSpecializationsByIdSpecialization(SpecializationModel specializationsByIdSpecialization) {
        this.specializationsByIdSpecialization = specializationsByIdSpecialization;
    }
}