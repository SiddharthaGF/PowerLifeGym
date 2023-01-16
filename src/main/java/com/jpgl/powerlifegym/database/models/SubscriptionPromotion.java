package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "subscription_promotions", schema = "powerlifegymdb", catalog = "")
public class SubscriptionPromotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_promotion")
    private Integer idPromotion;
    @Basic
    @Column(name = "id_subscription")
    private Integer idSubscription;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "subscriptionPromotionsByIdSubscriptionPromotions")
    private Collection<SubscriptionPayment> subscriptionPaymentsById;
    @ManyToOne
    @JoinColumn(name = "id_promotion", referencedColumnName = "id", insertable = false, updatable = false)
    private Promotion promotionsByIdPromotion;
    @ManyToOne
    @JoinColumn(name = "id_subscription",  nullable = false, referencedColumnName = "id", insertable = false, updatable = false)
    private Subscription subscriptionsByIdSubscription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Integer getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Integer idSubscription) {
        this.idSubscription = idSubscription;
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

        SubscriptionPromotion that = (SubscriptionPromotion) o;

        if (id != that.id) return false;
        if (idPromotion != null ? !idPromotion.equals(that.idPromotion) : that.idPromotion != null) return false;
        if (idSubscription != null ? !idSubscription.equals(that.idSubscription) : that.idSubscription != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idPromotion != null ? idPromotion.hashCode() : 0);
        result = 31 * result + (idSubscription != null ? idSubscription.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<SubscriptionPayment> getSubscriptionPaymentsById() {
        return subscriptionPaymentsById;
    }

    public void setSubscriptionPaymentsById(Collection<SubscriptionPayment> subscriptionPaymentsById) {
        this.subscriptionPaymentsById = subscriptionPaymentsById;
    }

    public Promotion getPromotionsByIdPromotion() {
        return promotionsByIdPromotion;
    }

    public void setPromotionsByIdPromotion(Promotion promotionsByIdPromotion) {
        this.promotionsByIdPromotion = promotionsByIdPromotion;
    }

    public Subscription getSubscriptionsByIdSubscription() {
        return subscriptionsByIdSubscription;
    }

    public void setSubscriptionsByIdSubscription(Subscription subscriptionsByIdSubscription) {
        this.subscriptionsByIdSubscription = subscriptionsByIdSubscription;
    }
}
