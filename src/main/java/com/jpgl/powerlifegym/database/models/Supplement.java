package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "supplements")
@PrimaryKeyJoinColumn ( name = "id_product")
public class Supplement extends Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_product", insertable = false, updatable = false)
    private int idProduct;
    @Basic
    @Column(name = "id_presentation")
    private int idPresentation;
    @Basic
    @Column(name = "content")
    private int content;
    @Basic
    @Column(name = "units")
    private String units;
    @Basic
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Product productsByIdProduct;
    @ManyToOne
    @JoinColumn(name = "id_presentation", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Presentation presentationsByIdPresentation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(int idPresentation) {
        this.idPresentation = idPresentation;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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

        Supplement that = (Supplement) o;

        if (id != that.id) return false;
        if (idProduct != that.idProduct) return false;
        if (idPresentation != that.idPresentation) return false;
        if (content != that.content) return false;
        if (units != null ? !units.equals(that.units) : that.units != null) return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idProduct;
        result = 31 * result + idPresentation;
        result = 31 * result + content;
        result = 31 * result + (units != null ? units.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Product getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(Product productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }

    public Presentation getPresentationsByIdPresentation() {
        return presentationsByIdPresentation;
    }

    public void setPresentationsByIdPresentation(Presentation presentationsByIdPresentation) {
        this.presentationsByIdPresentation = presentationsByIdPresentation;
    }
}
