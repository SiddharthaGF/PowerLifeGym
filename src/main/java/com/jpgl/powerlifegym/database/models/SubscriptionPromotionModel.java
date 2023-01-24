package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "subscription_promotions", schema = "prueba", catalog = "")
public class SubscriptionPromotionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "id_promotion", nullable = false, insertable=false, updatable=false)
    private int idPromotion;
    @Basic
    @Column(name = "id_subscription", nullable = false, insertable=false, updatable=false)
    private int idSubscription;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @OneToMany(mappedBy = "subscriptionPromotionsByIdSubscriptionPromotions")
    private Collection<SubscriptionPaymentModel> subscriptionPaymentsById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_promotion", referencedColumnName = "id", nullable = false)
    private PromotionModel promotionsByIdPromotion;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subscription", referencedColumnName = "id", nullable = false)
    private SubscriptionModel subscriptionsByIdSubscription;

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

    public int getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
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

        SubscriptionPromotionModel that = (SubscriptionPromotionModel) o;

        if (id != that.id) return false;
        if (idPromotion != that.idPromotion) return false;
        if (idSubscription != that.idSubscription) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + idPromotion;
        result = 31 * result + idSubscription;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<SubscriptionPaymentModel> getSubscriptionPaymentsById() {
        return subscriptionPaymentsById;
    }

    public void setSubscriptionPaymentsById(Collection<SubscriptionPaymentModel> subscriptionPaymentsById) {
        this.subscriptionPaymentsById = subscriptionPaymentsById;
    }

    public PromotionModel getPromotionsByIdPromotion() {
        return promotionsByIdPromotion;
    }

    public void setPromotionsByIdPromotion(PromotionModel promotionsByIdPromotion) {
        this.promotionsByIdPromotion = promotionsByIdPromotion;
    }

    public SubscriptionModel getSubscriptionsByIdSubscription() {
        return subscriptionsByIdSubscription;
    }

    public void setSubscriptionsByIdSubscription(SubscriptionModel subscriptionsByIdSubscription) {
        this.subscriptionsByIdSubscription = subscriptionsByIdSubscription;
    }
}
