package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn ( name = "id_person")
public class Client extends Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idClient;

    @Basic
    @Column(name = "id_person", insertable = false, updatable = false)
    private Integer idPerson;

    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAtClient;

    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAtClient;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", insertable = false, updatable = false)
    private Person peopleByIdPerson;

    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<Inscription> inscriptionsById;

    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<PhysicalMonitoring> physicalMonitoringsById;

    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<CustomerAssistance> presenceClientsById;

    public int getId() {
        return idClient;
    }

    public void setId(int id) {
        this.idClient = id;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Timestamp getCreatedAtClient() {
        return createdAtClient;
    }

    public Timestamp getUpdatedAtClient() {
        return updatedAtClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Client that = (Client) o;
        return idClient == that.idClient && Objects.equals (idPerson, that.idPerson) && Objects.equals (createdAtClient, that.createdAtClient) && Objects.equals (updatedAtClient, that.updatedAtClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash (idClient, idPerson, createdAtClient, updatedAtClient);
    }

    public Person getPeopleByIdPerson() {
        return peopleByIdPerson;
    }

    public void setPeopleByIdPerson(Person peopleByIdPerson) {
        this.peopleByIdPerson = peopleByIdPerson;
    }

    public Collection<Inscription> getInscriptionsById() {
        return inscriptionsById;
    }

    public void setInscriptionsById(Collection<Inscription> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }

    public Collection<PhysicalMonitoring> getPhysicalMonitoringsById() {
        return physicalMonitoringsById;
    }

    public void setPhysicalMonitoringsById(Collection<PhysicalMonitoring> physicalMonitoringsById) {
        this.physicalMonitoringsById = physicalMonitoringsById;
    }

    public Collection<CustomerAssistance> getPresenceClientsById() {
        return presenceClientsById;
    }

    public void setPresenceClientsById(Collection<CustomerAssistance> presenceClientsById) {
        this.presenceClientsById = presenceClientsById;
    }
}
