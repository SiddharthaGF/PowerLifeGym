package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "subscription_payment", schema = "powerlifegymdb", catalog = "")
public class SubscriptionPayment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_payment_method")
    private int idPaymentMethod;
    @Basic
    @Column(name = "id_client")
    private int idClient;
    @Basic
    @Column(name = "id_subscription")
    private int idSubscription;
    @Basic
    @Column(name = "id_subscription_promotions")
    private Integer idSubscriptionPromotions;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_payment_method", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private PaymentMethod paymentMethodByIdPaymentMethod;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Client clientsByIdClient;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subscription", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Subscription subscriptionsByIdSubscription;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subscription_promotions", referencedColumnName = "id", insertable = false, updatable = false)
    private SubscriptionPromotion subscriptionPromotionsByIdSubscriptionPromotions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(int idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
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

        SubscriptionPayment that = (SubscriptionPayment) o;

        if (id != that.id) return false;
        if (idPaymentMethod != that.idPaymentMethod) return false;
        if (idClient != that.idClient) return false;
        if (idSubscription != that.idSubscription) return false;
        if (idSubscriptionPromotions != null ? !idSubscriptionPromotions.equals(that.idSubscriptionPromotions) : that.idSubscriptionPromotions != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPaymentMethod;
        result = 31 * result + idClient;
        result = 31 * result + idSubscription;
        result = 31 * result + (idSubscriptionPromotions != null ? idSubscriptionPromotions.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public PaymentMethod getPaymentMethodByIdPaymentMethod() {
        return paymentMethodByIdPaymentMethod;
    }

    public void setPaymentMethodByIdPaymentMethod(PaymentMethod paymentMethodByIdPaymentMethod) {
        this.paymentMethodByIdPaymentMethod = paymentMethodByIdPaymentMethod;
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

    public SubscriptionPromotion getSubscriptionPromotionsByIdSubscriptionPromotions() {
        return subscriptionPromotionsByIdSubscriptionPromotions;
    }

    public void setSubscriptionPromotionsByIdSubscriptionPromotions(SubscriptionPromotion subscriptionPromotionsByIdSubscriptionPromotions) {
        this.subscriptionPromotionsByIdSubscriptionPromotions = subscriptionPromotionsByIdSubscriptionPromotions;
    }
}
