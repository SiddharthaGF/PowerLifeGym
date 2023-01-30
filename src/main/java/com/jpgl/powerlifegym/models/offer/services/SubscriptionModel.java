package com.jpgl.powerlifegym.models.offer.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.models.offer.OfferModel;
import com.jpgl.powerlifegym.models.invoice.SubscriptionPaymentModel;
import com.jpgl.powerlifegym.models.offer.promotion.SubscriptionPromotionModel;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@DiscriminatorValue("subscription")
public class SubscriptionModel extends OfferModel {
    @Basic
    @Column(name = "name", length = 255)
    private String name;
    /*@JsonIgnore
    @OneToMany(mappedBy = "subscriptionsByIdSubscription")
    private Collection<InscriptionModel> inscriptionsById;*/
    @JsonIgnore
    @OneToMany(mappedBy = "subscriptionsByIdSubscription")
    private Collection<SubscriptionPaymentModel> subscriptionPaymentsById;
    @JsonIgnore
    @OneToMany(mappedBy = "subscriptionsByIdSubscription")
    private Collection<SubscriptionPromotionModel> subscriptionPromotionsById;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setInscriptionsById(Collection<InscriptionModel> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }

    public InscriptionModel getInscriptionsById() {
        return subscriptionsById;
    }*/

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
