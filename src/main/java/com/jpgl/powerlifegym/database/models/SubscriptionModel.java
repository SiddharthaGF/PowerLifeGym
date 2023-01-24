package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "subscriptions", schema = "prueba", catalog = "")
public class SubscriptionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @OneToMany(mappedBy = "subscriptionsByIdSubscription")
    private Collection<InscriptionModel> inscriptionsById;
    @JsonIgnore
    @OneToMany(mappedBy = "subscriptionsByIdSubscription")
    private Collection<SubscriptionPaymentModel> subscriptionPaymentsById;
    @JsonIgnore
    @OneToMany(mappedBy = "subscriptionsByIdSubscription")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

        SubscriptionModel that = (SubscriptionModel) o;

        if (id != that.id) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<InscriptionModel> getInscriptionsById() {
        return inscriptionsById;
    }

    public void setInscriptionsById(Collection<InscriptionModel> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }

    public Collection<SubscriptionPaymentModel> getSubscriptionPaymentsById() {
        return subscriptionPaymentsById;
    }

    public void setSubscriptionPaymentsById(Collection<SubscriptionPaymentModel> subscriptionPaymentsById) {
        this.subscriptionPaymentsById = subscriptionPaymentsById;
    }

    public Collection<SubscriptionPromotionModel> getSubscriptionPromotionsById() {
        return subscriptionPromotionsById;
    }

    public void setSubscriptionPromotionsById(Collection<SubscriptionPromotionModel> subscriptionPromotionsById) {
        this.subscriptionPromotionsById = subscriptionPromotionsById;
    }
}
