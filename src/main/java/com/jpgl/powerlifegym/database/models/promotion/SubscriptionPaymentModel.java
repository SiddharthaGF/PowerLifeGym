package com.jpgl.powerlifegym.database.models.promotion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.database.models.offer.services.SubscriptionModel;
import com.jpgl.powerlifegym.database.models.person.ClientModel;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "subscription_payment")
public class SubscriptionPaymentModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "id_client", nullable = false, insertable = false, updatable = false)
    private int idClient;
    @Basic
    @Column(name = "id_subscription", nullable = false, insertable = false, updatable = false)
    private int idSubscription;
    @Basic
    @Column(name = "id_subscription_promotions", nullable = true, insertable = false, updatable = false)
    private Integer idSubscriptionPromotions;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private ClientModel clientsByIdClient;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subscription", referencedColumnName = "id", nullable = false)
    private SubscriptionModel subscriptionsByIdSubscription;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subscription_promotions", referencedColumnName = "id")
    private SubscriptionPromotionModel subscriptionPromotionsByIdSubscriptionPromotions;

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

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public Integer getIdSubscriptionPromotions() {
        return idSubscriptionPromotions;
    }

    public void setIdSubscriptionPromotions(Integer idSubscriptionPromotions) {
        this.idSubscriptionPromotions = idSubscriptionPromotions;
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

        SubscriptionPaymentModel that = (SubscriptionPaymentModel) o;

        if (id != that.id) return false;
        if (idClient != that.idClient) return false;
        if (idSubscription != that.idSubscription) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (idSubscriptionPromotions != null ? !idSubscriptionPromotions.equals(that.idSubscriptionPromotions) : that.idSubscriptionPromotions != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + idClient;
        result = 31 * result + idSubscription;
        result = 31 * result + (idSubscriptionPromotions != null ? idSubscriptionPromotions.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public ClientModel getClientsByIdClient() {
        return clientsByIdClient;
    }

    public void setClientsByIdClient(ClientModel clientsByIdClient) {
        this.clientsByIdClient = clientsByIdClient;
    }

    public SubscriptionModel getSubscriptionsByIdSubscription() {
        return subscriptionsByIdSubscription;
    }

    public void setSubscriptionsByIdSubscription(SubscriptionModel subscriptionsByIdSubscription) {
        this.subscriptionsByIdSubscription = subscriptionsByIdSubscription;
    }

    public SubscriptionPromotionModel getSubscriptionPromotionsByIdSubscriptionPromotions() {
        return subscriptionPromotionsByIdSubscriptionPromotions;
    }

    public void setSubscriptionPromotionsByIdSubscriptionPromotions(SubscriptionPromotionModel subscriptionPromotionsByIdSubscriptionPromotions) {
        this.subscriptionPromotionsByIdSubscriptionPromotions = subscriptionPromotionsByIdSubscriptionPromotions;
    }
}
