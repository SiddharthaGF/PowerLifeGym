package com.jpgl.powerlifegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "products")
@Inheritance ( strategy=InheritanceType.JOINED )
public class Product implements Serializable {
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
    private Collection<Promotion> promotionsById;
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
        if (o == null || getClass () != o.getClass ()) return false;
        Product that = (Product) o;
        return id == that.id && Objects.equals (price, that.price) && Objects.equals (description, that.description) && Objects.equals (quantity, that.quantity) && Objects.equals (brand, that.brand) && Objects.equals (createdAt, that.createdAt) && Objects.equals (updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, price, description, quantity, brand, createdAt, updatedAt);
    }

    public Collection<Cloth> getClothesById() {
        return clothesById;
    }

    public void setClothesById(Collection<Cloth> clothesById) {
        this.clothesById = clothesById;
    }

    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    public Collection<Supplement> getSupplementsById() {
        return supplementsById;
    }

    public void setSupplementsById(Collection<Supplement> supplementsById) {
        this.supplementsById = supplementsById;
    }
}
