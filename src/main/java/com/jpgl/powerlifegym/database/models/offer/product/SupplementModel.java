package com.jpgl.powerlifegym.database.models.offer.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@DiscriminatorValue("supplement")
public class SupplementModel extends ProductModel {

    @Basic
    @Column(name = "brand", nullable = true, length = 255)
    private String brand;
    @Basic
    @Column(name = "description", length = 255)
    private String description;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "content", nullable = true)
    private Integer content;
    @Basic
    @Column(name = "expiration_date", nullable = true)
    private Date expirationDate;
    @Basic
    @Column(name = "id_presentation", insertable=false, updatable=false)
    private String idPresentation;
    @Basic
    @Column(name = "units", nullable = true, length = 255)
    private String units;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_presentation", referencedColumnName = "id", nullable = false)
    private PresentationModel presentationsByIdPresentation;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }


    public PresentationModel getPresentationsByIdPresentation() {
        return presentationsByIdPresentation;
    }

    public void setPresentationsByIdPresentation(PresentationModel presentationsByIdPresentation) {
        this.presentationsByIdPresentation = presentationsByIdPresentation;
    }

}
