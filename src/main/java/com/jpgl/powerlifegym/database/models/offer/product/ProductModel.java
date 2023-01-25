package com.jpgl.powerlifegym.database.models.offer.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.database.models.offer.OfferModel;
import com.jpgl.powerlifegym.database.models.promotion.ProductPromotionModel;
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
