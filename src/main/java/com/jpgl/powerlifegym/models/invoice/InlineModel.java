package com.jpgl.powerlifegym.models.invoice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.models.offer.OfferModel;
import com.jpgl.powerlifegym.models.offer.promotion.ProductPromotionModel;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "inline")
public class InlineModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "id_invoice", nullable = false, insertable=false, updatable=false)
    private int idInvoice;
    @Basic
    @Column(name = "id_product", nullable = false, insertable=false, updatable=false)
    private int idProduct;
    @Basic
    @Column(name = "id_product_promotions", nullable = true, insertable=false, updatable=false)
    private Integer idProductPromotions;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_invoice", referencedColumnName = "id", nullable = false)
    private InvoiceModel invoiceByIdInvoice;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private OfferModel productsByIdProduct;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product_promotions", referencedColumnName = "id")
    private ProductPromotionModel productPromotionsByIdProductPromotions;

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

        InlineModel that = (InlineModel) o;

        if (id != that.id) return false;
        if (idInvoice != that.idInvoice) return false;
        if (idProduct != that.idProduct) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (idProductPromotions != null ? !idProductPromotions.equals(that.idProductPromotions) : that.idProductPromotions != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + idInvoice;
        result = 31 * result + idProduct;
        result = 31 * result + (idProductPromotions != null ? idProductPromotions.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public InvoiceModel getInvoiceByIdInvoice() {
        return invoiceByIdInvoice;
    }

    public void setInvoiceByIdInvoice(InvoiceModel invoiceByIdInvoice) {
        this.invoiceByIdInvoice = invoiceByIdInvoice;
    }

    public OfferModel getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(OfferModel productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }

    public ProductPromotionModel getProductPromotionsByIdProductPromotions() {
        return productPromotionsByIdProductPromotions;
    }

    public void setProductPromotionsByIdProductPromotions(ProductPromotionModel productPromotionsByIdProductPromotions) {
        this.productPromotionsByIdProductPromotions = productPromotionsByIdProductPromotions;
    }
}
