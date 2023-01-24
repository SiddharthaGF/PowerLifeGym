package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cellphone_numbers")
public class CellphoneNumberModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "id_client")
    private Integer idClient;
    @Basic
    @Column(name = "id_instructor")
    private Integer idInstructor;
    @Basic
    @Column(name = "number", nullable = false, length = 10, unique = true)
    private String number;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", insertable = false, updatable = false)
    private ClientModel clientsByIdPerson;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_instructor", referencedColumnName = "id", insertable = false, updatable = false)
    private InstructorModel instructorByIdPerson;
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

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

        CellphoneNumberModel that = (CellphoneNumberModel) o;

        if (id != that.id) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (idClient != null ? !idClient.equals(that.idClient) : that.idClient != null) return false;
        if (idInstructor != null ? !idInstructor.equals(that.idInstructor) : that.idInstructor != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (idClient != null ? idClient.hashCode() : 0);
        result = 31 * result + (idInstructor != null ? idInstructor.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public ClientModel getClientsByIdPerson() {
        return clientsByIdPerson;
    }

    public void setClientsByIdPerson(ClientModel clientsByIdPerson) {
        this.clientsByIdPerson = clientsByIdPerson;
    }

    public InstructorModel getInstructorByIdPerson() {
        return instructorByIdPerson;
    }

    public void setInstructorByIdPerson(InstructorModel instructorByIdPerson) {
        this.instructorByIdPerson = instructorByIdPerson;
    }

}
