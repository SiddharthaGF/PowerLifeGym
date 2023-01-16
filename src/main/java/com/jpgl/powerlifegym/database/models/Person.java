package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "people")
@Inheritance ( strategy=InheritanceType.JOINED )
public class Person {
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
    @Column(name = "dni")
    private String dni;
    @Basic
    @Column(name = "id_gender")
    private int idGender;
    @Basic
    @Column(name = "birthdate")
    private Date birthdate;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "peopleByIdPerson")
    private Collection<CellphoneNumber> cellphoneNumbersById;
    @OneToMany(mappedBy = "peopleByIdPerson")
    private Collection<Client> clientsById;
    @OneToMany(mappedBy = "peopleByIdPerson")
    private Collection<Email> emailsById;
    @OneToMany(mappedBy = "peopleByIdPerson")
    private Collection<Instructor> instructorsById;
    @ManyToOne
    @JoinColumn(name = "id_gender", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Gender gendersByIdGender;

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

        Person people = (Person) o;

        if (id != people.id) return false;
        if (idGender != people.idGender) return false;
        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        if (lastname != null ? !lastname.equals(people.lastname) : people.lastname != null) return false;
        if (dni != null ? !dni.equals(people.dni) : people.dni != null) return false;
        if (birthdate != null ? !birthdate.equals(people.birthdate) : people.birthdate != null) return false;
        if (createdAt != null ? !createdAt.equals(people.createdAt) : people.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(people.updatedAt) : people.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + idGender;
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
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
