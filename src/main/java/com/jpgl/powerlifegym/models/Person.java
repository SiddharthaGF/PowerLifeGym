package com.jpgl.powerlifegym.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "people")
@Inheritance ( strategy=InheritanceType.JOINED )
public class Person implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "id_gender")
    private int idGender;

    @Basic
    @Column(name = "birthdate")
    private Date birthdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "peopleByIdPerson")
    private Collection<CellphoneNumber> cellphoneNumbersById;

    @JsonIgnore
    @OneToMany(mappedBy = "peopleByIdPerson")
    private Collection<Client> clientsById;

    @JsonIgnore
    @OneToMany(mappedBy = "peopleByIdPerson")
    private Collection<Email> emailsById;

    @JsonIgnore
    @OneToMany(mappedBy = "peopleByIdPerson")
    private Collection<Instructor> instructorsById;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_gender", referencedColumnName = "id", insertable = false, updatable = false)
    private Gender gendersByIdGender;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getIdGender() { return idGender; }

    public void setIdGender(int idGender) { this.idGender = idGender; }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

    private Timestamp getCreatedAt() { return createdAt; }

    private Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Person that = (Person) o;
        return id == that.id && Objects.equals (name, that.name) && Objects.equals (lastname, that.lastname) && Objects.equals (idGender, that.idGender) && Objects.equals (birthdate, that.birthdate) && Objects.equals (createdAt, that.createdAt) && Objects.equals (updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, name, lastname, idGender, birthdate, createdAt, updatedAt);
    }

    public Collection<CellphoneNumber> getCellphoneNumbersById() {
        return cellphoneNumbersById;
    }

    public void setCellphoneNumbersById(Collection<CellphoneNumber> cellphoneNumbersById) {
        this.cellphoneNumbersById = cellphoneNumbersById;
    }

    public Collection<Client> getClientsById() {
        return clientsById;
    }

    public void setClientsById(Collection<Client> clientsById) {
        this.clientsById = clientsById;
    }

    public Collection<Email> getEmailsById() {
        return emailsById;
    }

    public void setEmailsById(Collection<Email> emailsById) {
        this.emailsById = emailsById;
    }

    public Collection<Instructor> getInstructorsById() {
        return instructorsById;
    }

    public void setInstructorsById(Collection<Instructor> instructorsById) {
        this.instructorsById = instructorsById;
    }

    public Gender getGendersByIdGender() {
        return gendersByIdGender;
    }

    public void setGendersByIdGender(Gender gendersByIdGender) {
        this.gendersByIdGender = gendersByIdGender;
    }
}
