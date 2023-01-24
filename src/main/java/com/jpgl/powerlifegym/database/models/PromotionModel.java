package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "promotions", schema = "prueba", catalog = "")
public class PromotionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "discount", nullable = false)
    private int discount;
    @Basic
    @Column(name = "effective_date", nullable = true)
    private Date effectiveDate;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @OneToMany(mappedBy = "promotionsByIdPromotion")
    private Collection<ProductPromotionModel> productPromotionsById;
    @JsonIgnore
    @OneToMany(mappedBy = "promotionsByIdPromotion")
    private Collection<SubscriptionPromotionModel> subscriptionPromotionsById;

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

        PromotionModel that = (PromotionModel) o;

        if (id != that.id) return false;
        if (discount != that.discount) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (effectiveDate != null ? !effectiveDate.equals(that.effectiveDate) : that.effectiveDate != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + discount;
        result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<ProductPromotionModel> getProductPromotionsById() {
        return productPromotionsById;
    }

    public void setProductPromotionsById(Collection<ProductPromotionModel> productPromotionsById) {
        this.productPromotionsById = productPromotionsById;
    }

    public Collection<SubscriptionPromotionModel> getSubscriptionPromotionsById() {
        return subscriptionPromotionsById;
    }

    public void setSubscriptionPromotionsById(Collection<SubscriptionPromotionModel> subscriptionPromotionsById) {
        this.subscriptionPromotionsById = subscriptionPromotionsById;
    }
}
