package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "product_promotions")
public class ProductPromotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_promotion")
    private Integer idPromotion;
    @Basic
    @Column(name = "id_product")
    private Integer idProduct;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "productPromotionsByIdProductPromotions")
    private Collection<Inline> inlinesById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_promotion", referencedColumnName = "id", insertable = false, updatable = false)
    private Promotion promotionsByIdPromotion;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Product productsByIdProduct;

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

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
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

        ProductPromotion that = (ProductPromotion) o;

        if (id != that.id) return false;
        if (idPromotion != null ? !idPromotion.equals(that.idPromotion) : that.idPromotion != null) return false;
        if (idProduct != null ? !idProduct.equals(that.idProduct) : that.idProduct != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idPromotion != null ? idPromotion.hashCode() : 0);
        result = 31 * result + (idProduct != null ? idProduct.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<Inline> getInlinesById() {
        return inlinesById;
    }

    public void setInlinesById(Collection<Inline> inlinesById) {
        this.inlinesById = inlinesById;
    }

    public Promotion getPromotionsByIdPromotion() {
        return promotionsByIdPromotion;
    }

    public void setPromotionsByIdPromotion(Promotion promotionsByIdPromotion) {
        this.promotionsByIdPromotion = promotionsByIdPromotion;
    }

    public Product getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(Product productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }
}
