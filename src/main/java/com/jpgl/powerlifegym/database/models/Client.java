package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn ( name = "id_person")
public class Client extends Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_person", insertable = false, updatable = false)
    private Integer idPerson;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id", insertable = false, updatable = false)
    private Person peopleByIdPerson;
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<Inscription> inscriptionsById;
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<Invoice> invoicesById;
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<PhysicalMonitoring> physicalMonitoringsById;
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<PresenceClient> presenceClientsById;
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<SubscriptionPayment> subscriptionPaymentsById;

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

        Client client = (Client) o;

        if (id != client.id) return false;
        if (idPerson != null ? !idPerson.equals(client.idPerson) : client.idPerson != null) return false;
        if (createdAt != null ? !createdAt.equals(client.createdAt) : client.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(client.updatedAt) : client.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idPerson != null ? idPerson.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
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

    public Collection<Invoice> getInvoicesById() {
        return invoicesById;
    }

    public void setInvoicesById(Collection<Invoice> invoicesById) {
        this.invoicesById = invoicesById;
    }

    public Collection<PhysicalMonitoring> getPhysicalMonitoringsById() {
        return physicalMonitoringsById;
    }

    public void setPhysicalMonitoringsById(Collection<PhysicalMonitoring> physicalMonitoringsById) {
        this.physicalMonitoringsById = physicalMonitoringsById;
    }

    public Collection<PresenceClient> getPresenceClientsById() {
        return presenceClientsById;
    }

    public void setPresenceClientsById(Collection<PresenceClient> presenceClientsById) {
        this.presenceClientsById = presenceClientsById;
    }

    public Collection<SubscriptionPayment> getSubscriptionPaymentsById() {
        return subscriptionPaymentsById;
    }

    public void setSubscriptionPaymentsById(Collection<SubscriptionPayment> subscriptionPaymentsById) {
        this.subscriptionPaymentsById = subscriptionPaymentsById;
    }
}
