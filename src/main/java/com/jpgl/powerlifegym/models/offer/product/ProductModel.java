package com.jpgl.powerlifegym.models.offer.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.models.offer.OfferModel;
import com.jpgl.powerlifegym.models.offer.promotion.ProductPromotionModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class ProductModel extends OfferModel {

    @JsonIgnore
    @OneToMany(mappedBy = "productsByIdProduct")
    private Collection<ProductPromotionModel> productPromotionsById;

    public Collection<ProductPromotionModel> getProductPromotionsById() {
        return productPromotionsById;
    }

    public void setProductPromotionsById(Collection<ProductPromotionModel> productPromotionsById) {
        this.productPromotionsById = productPromotionsById;
    }

}
