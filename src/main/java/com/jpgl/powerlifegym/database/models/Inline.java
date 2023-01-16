package com.jpgl.powerlifegym.database.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Inline {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_invoice")
    private int idInvoice;
    @Basic
    @Column(name = "id_product")
    private int idProduct;
    @Basic
    @Column(name = "id_product_promotions")
    private Integer idProductPromotions;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "id_invoice", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Invoice invoiceByIdInvoice;
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Product productsByIdProduct;
    @ManyToOne
    @JoinColumn(name = "id_product_promotions", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductPromotion productPromotionsByIdProductPromotions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdProductPromotions() {
        return idProductPromotions;
    }

    public void setIdProductPromotions(Integer idProductPromotions) {
        this.idProductPromotions = idProductPromotions;
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

        Inline inline = (Inline) o;

        if (id != inline.id) return false;
        if (idInvoice != inline.idInvoice) return false;
        if (idProduct != inline.idProduct) return false;
        if (idProductPromotions != null ? !idProductPromotions.equals(inline.idProductPromotions) : inline.idProductPromotions != null)
            return false;
        if (createdAt != null ? !createdAt.equals(inline.createdAt) : inline.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(inline.updatedAt) : inline.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idInvoice;
        result = 31 * result + idProduct;
        result = 31 * result + (idProductPromotions != null ? idProductPromotions.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Invoice getInvoiceByIdInvoice() {
        return invoiceByIdInvoice;
    }

    public void setInvoiceByIdInvoice(Invoice invoiceByIdInvoice) {
        this.invoiceByIdInvoice = invoiceByIdInvoice;
    }

    public Product getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(Product productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }

    public ProductPromotion getProductPromotionsByIdProductPromotions() {
        return productPromotionsByIdProductPromotions;
    }

    public void setProductPromotionsByIdProductPromotions(ProductPromotion productPromotionsByIdProductPromotions) {
        this.productPromotionsByIdProductPromotions = productPromotionsByIdProductPromotions;
    }
}
