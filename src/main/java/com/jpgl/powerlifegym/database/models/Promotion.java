package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "promotions", schema = "powerlifegymdb", catalog = "")
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "discount")
    private int discount;
    @Basic
    @Column(name = "effective_date")
    private Date effectiveDate;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "promotionsByIdPromotion")
    private Collection<ProductPromotion> productPromotionsById;
    @OneToMany(mappedBy = "promotionsByIdPromotion")
    private Collection<SubscriptionPromotion> subscriptionPromotionsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (discount != promotion.discount) return false;
        if (effectiveDate != null ? !effectiveDate.equals(promotion.effectiveDate) : promotion.effectiveDate != null)
            return false;
        if (createdAt != null ? !createdAt.equals(promotion.createdAt) : promotion.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(promotion.updatedAt) : promotion.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + discount;
        result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<ProductPromotion> getProductPromotionsById() {
        return productPromotionsById;
    }

    public void setProductPromotionsById(Collection<ProductPromotion> productPromotionsById) {
        this.productPromotionsById = productPromotionsById;
    }

    public Collection<SubscriptionPromotion> getSubscriptionPromotionsById() {
        return subscriptionPromotionsById;
    }

    public void setSubscriptionPromotionsById(Collection<SubscriptionPromotion> subscriptionPromotionsById) {
        this.subscriptionPromotionsById = subscriptionPromotionsById;
    }
}
