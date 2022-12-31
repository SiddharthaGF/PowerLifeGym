package com.jpgl.powerlifegym.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "supplements")
@PrimaryKeyJoinColumn ( name = "id_product")
public class Supplement extends Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_supplement;
    @Basic
    @Column(name = "id_product", insertable = false, updatable = false)
    private Integer idProduct;
    @Basic
    @Column(name = "id_presentation")
    private Integer idPresentation;
    @Basic
    @Column(name = "content")
    private Integer content;
    @Basic
    @Column(name = "units")
    private String units;
    @Basic
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAtSupplement;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAtSupplement;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", insertable = false, updatable = false)
    private Product productsByIdProduct;
    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "id_presentation", referencedColumnName = "id", insertable = false, updatable = false)
    private PresentationProduct presentationsByIdPresentation;

    public int getId_supplement() {
        return id_supplement;
    }

    public void setId_supplement(int id_supplement) {
        this.id_supplement = id_supplement;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(Integer idPresentation) {
        this.idPresentation = idPresentation;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Date getExpirationDate() { return expirationDate; }

    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public Timestamp getCreatedAtSupplement() {
        return createdAtSupplement;
    }

    public Timestamp getUpdatedAtSupplement() {
        return updatedAtSupplement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Supplement that = (Supplement) o;
        return id_supplement == that.id_supplement && Objects.equals (idProduct, that.idProduct) && Objects.equals (idPresentation, that.idPresentation) && Objects.equals (content, that.content) && Objects.equals (units, that.units) && Objects.equals (createdAtSupplement, that.createdAtSupplement) && Objects.equals (updatedAtSupplement, that.updatedAtSupplement);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id_supplement, idProduct, idPresentation, content, units, createdAtSupplement, updatedAtSupplement);
    }

    public Product getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(Product productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }

    public PresentationProduct getPresentationsByIdPresentation() {
        return presentationsByIdPresentation;
    }

    public void setPresentationsByIdPresentation(PresentationProduct presentationsByIdPresentation) {
        this.presentationsByIdPresentation = presentationsByIdPresentation;
    }
}
