package com.jpgl.powerlifegym.models.offer.promotion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.models.invoice.SubscriptionPaymentModel;
import com.jpgl.powerlifegym.models.offer.services.SubscriptionModel;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@DiscriminatorValue(value="subscription")
public class SubscriptionPromotionModel extends PromotionModel {
    @Basic
    @Column(name = "id_subscription", nullable = false, insertable=false, updatable=false)
    private int idSubscription;
    @JsonIgnore
    @OneToMany(mappedBy = "subscriptionPromotionsByIdSubscriptionPromotions")
    private Collection<SubscriptionPaymentModel> subscriptionPaymentsById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subscription", referencedColumnName = "id", nullable = false)
    private SubscriptionModel subscriptionsByIdSubscription;

    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public Collection<SubscriptionPaymentModel> getSubscriptionPaymentsById() {
        return subscriptionPaymentsById;
    }

    public void setSubscriptionPaymentsById(Collection<SubscriptionPaymentModel> subscriptionPaymentsById) {
        this.subscriptionPaymentsById = subscriptionPaymentsById;
    }

    public SubscriptionModel getSubscriptionsByIdSubscription() {
        return subscriptionsByIdSubscription;
    }

    public void setSubscriptionsByIdSubscription(SubscriptionModel subscriptionsByIdSubscription) {
        this.subscriptionsByIdSubscription = subscriptionsByIdSubscription;
    }
}
