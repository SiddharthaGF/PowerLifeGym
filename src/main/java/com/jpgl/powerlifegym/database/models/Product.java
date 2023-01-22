package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "products")
@Inheritance ( strategy=InheritanceType.JOINED )
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "brand")
    private String brand;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByIdProduct")
    private Collection<Cloth> clothesById;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByIdProduct")
    private Collection<Inline> inlinesById;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByIdProduct")
    private Collection<ProductPromotion> productPromotionsById;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByIdProduct")
    private Collection<Supplement> supplementsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (quantity != null ? !quantity.equals(product.quantity) : product.quantity != null) return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (createdAt != null ? !createdAt.equals(product.createdAt) : product.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(product.updatedAt) : product.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<Cloth> getClothesById() {
        return clothesById;
    }

    public void setClothesById(Collection<Cloth> clothesById) {
        this.clothesById = clothesById;
    }

    public Collection<Inline> getInlinesById() {
        return inlinesById;
    }

    public void setInlinesById(Collection<Inline> inlinesById) {
        this.inlinesById = inlinesById;
    }

    public Collection<ProductPromotion> getProductPromotionsById() {
        return productPromotionsById;
    }

    public void setProductPromotionsById(Collection<ProductPromotion> productPromotionsById) {
        this.productPromotionsById = productPromotionsById;
    }

    public Collection<Supplement> getSupplementsById() {
        return supplementsById;
    }

    public void setSupplementsById(Collection<Supplement> supplementsById) {
        this.supplementsById = supplementsById;
    }
}
