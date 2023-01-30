package com.jpgl.powerlifegym.models.offer.promotion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.models.invoice.InlineModel;
import com.jpgl.powerlifegym.models.offer.OfferModel;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@DiscriminatorValue(value="product")
public class ProductPromotionModel extends PromotionModel {
    @Basic
    @Column(name = "id_product", nullable = false, insertable=false, updatable=false)
    private int idProduct;
    @JsonIgnore
    @OneToMany(mappedBy = "productPromotionsByIdProductPromotions")
    private Collection<InlineModel> inlinesById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private OfferModel productsByIdProduct;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Collection<InlineModel> getInlinesById() {
        return inlinesById;
    }

    public void setInlinesById(Collection<InlineModel> inlinesById) {
        this.inlinesById = inlinesById;
    }

    public OfferModel getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(OfferModel productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }

}
