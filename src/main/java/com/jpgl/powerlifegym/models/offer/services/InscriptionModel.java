package com.jpgl.powerlifegym.models.offer.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.models.invoice.SubscriptionPaymentModel;
import com.jpgl.powerlifegym.models.people.GroupModel;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "inscriptions")
public class InscriptionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "id_group", nullable = true, insertable=false, updatable=false)
    private Integer idGroup;
    @Basic
    @Column(name = "id_subscription_payment", nullable = false, insertable=false, updatable=false)
    private int idSubscriptionPayment;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id")
    private GroupModel groupssByIdGroup;
    /*@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subscription", referencedColumnName = "id", nullable = false)
    private SubscriptionModel subscriptionsByIdSubscription;
*/
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_subscription_payment", referencedColumnName = "id")
    private SubscriptionPaymentModel subscriptionPaymentModelsByIdSubscriptionPaymentModels;

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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public int getIdSubscriptionPayment() {
        return idSubscriptionPayment;
    }

    public void setIdSubscriptionPayment(int idSubscriptionPayment) {
        this.idSubscriptionPayment = idSubscriptionPayment;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

        InscriptionModel that = (InscriptionModel) o;

        if (id != that.id) return false;
        if (idSubscriptionPayment != that.idSubscriptionPayment) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (idGroup != null ? !idGroup.equals(that.idGroup) : that.idGroup != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (idGroup != null ? idGroup.hashCode() : 0);
        result = 31 * result + idSubscriptionPayment;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public GroupModel getGroupssByIdGroup() {
        return groupssByIdGroup;
    }

    public void setGroupssByIdGroup(GroupModel groupssByIdGroup) {
        this.groupssByIdGroup = groupssByIdGroup;
    }

   /* public SubscriptionModel getSubscriptionsByIdSubscription() {
        return subscriptionsByIdSubscription;
    }

    public void setSubscriptionsByIdSubscription(SubscriptionModel subscriptionsByIdSubscription) {
        this.subscriptionsByIdSubscription = subscriptionsByIdSubscription;
    }*/
}
