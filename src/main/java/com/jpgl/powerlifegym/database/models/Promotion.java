package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "promotions")
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_product")
    private Integer idProduct;
    @Basic
    @Column(name = "discount")
    private int discount;
    @Basic
    @Column(name = "effective_date")
    private Date effectiveDate;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", insertable = false, updatable = false)
    private Product productsByIdProduct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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
        Promotion that = (Promotion) o;
        return id == that.id && Objects.equals (idProduct, that.idProduct) && Objects.equals (discount, that.discount) && Objects.equals (effectiveDate, that.effectiveDate) && Objects.equals (createdAt, that.createdAt) && Objects.equals (updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, idProduct, discount, effectiveDate, createdAt, updatedAt);
    }

    public Product getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(Product productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }
}
