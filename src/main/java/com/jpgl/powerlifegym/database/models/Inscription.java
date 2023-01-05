package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "inscriptions")
public class Inscription {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_client")
    private Integer idClient;
    @Basic
    @Column(name = "id_subscription")
    private Integer idSubscription;
    @Basic
    @Column(name = "id_group")
    private Integer idGroup;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", insertable = false, updatable = false)
    private Client clientsByIdClient;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subscription", referencedColumnName = "id", insertable = false, updatable = false)
    private Subscription subscriptionsByIdSubscription;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id", insertable = false, updatable = false)
    private Group groupsByIdGroup;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Integer idSubscription) {
        this.idSubscription = idSubscription;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        Inscription that = (Inscription) o;
        return id == that.id && Objects.equals (idClient, that.idClient) && Objects.equals (idSubscription, that.idSubscription) && Objects.equals (idGroup, that.idGroup) && Objects.equals (startDate, that.startDate) && Objects.equals (endDate, that.endDate) && Objects.equals (createdAt, that.createdAt) && Objects.equals (updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, idClient, idSubscription, idGroup, startDate, endDate, createdAt, updatedAt);
    }

    public Client getClientsByIdClient() {
        return clientsByIdClient;
    }

    public void setClientsByIdClient(Client clientsByIdClient) {
        this.clientsByIdClient = clientsByIdClient;
    }

    public Subscription getSubscriptionsByIdSubscription() {
        return subscriptionsByIdSubscription;
    }

    public void setSubscriptionsByIdSubscription(Subscription subscriptionsByIdSubscription) {
        this.subscriptionsByIdSubscription = subscriptionsByIdSubscription;
    }

    public Group getGroupsByIdGroup() {
        return groupsByIdGroup;
    }

    public void setGroupsByIdGroup(Group groupsByIdGroup) {
        this.groupsByIdGroup = groupsByIdGroup;
    }
}
