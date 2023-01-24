package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "product_promotions", schema = "prueba", catalog = "")
public class ProductPromotionModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "id_product", nullable = false, insertable=false, updatable=false)
    private int idProduct;
    @Basic
    @Column(name = "id_promotion", nullable = false, insertable=false, updatable=false)
    private int idPromotion;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @OneToMany(mappedBy = "productPromotionsByIdProductPromotions")
    private Collection<InlineModel> inlinesById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private ProductModel productsByIdProduct;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_promotion", referencedColumnName = "id", nullable = false)
    private PromotionModel promotionsByIdPromotion;

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

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
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

        ProductPromotionModel that = (ProductPromotionModel) o;

        if (id != that.id) return false;
        if (idProduct != that.idProduct) return false;
        if (idPromotion != that.idPromotion) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + idProduct;
        result = 31 * result + idPromotion;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<InlineModel> getInlinesById() {
        return inlinesById;
    }

    public void setInlinesById(Collection<InlineModel> inlinesById) {
        this.inlinesById = inlinesById;
    }

    public ProductModel getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(ProductModel productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }

    public PromotionModel getPromotionsByIdPromotion() {
        return promotionsByIdPromotion;
    }

    public void setPromotionsByIdPromotion(PromotionModel promotionsByIdPromotion) {
        this.promotionsByIdPromotion = promotionsByIdPromotion;
    }
}
