package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "products")
public class ProductModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "brand", nullable = true, length = 255)
    private String brand;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "color", nullable = true, length = 255)
    private String color;
    @Basic
    @Column(name = "id_gender", nullable = true, insertable=false, updatable=false)
    private Integer idGender;
    @Basic
    @Column(name = "size", nullable = true, length = 255)
    private String size;
    @Basic
    @Column(name = "content", nullable = true)
    private Integer content;
    @Basic
    @Column(name = "expiration_date", nullable = true)
    private Date expirationDate;
    @Basic
    @Column(name = "id_presentation", nullable = false, insertable=false, updatable=false)
    private int idPresentation;
    @Basic
    @Column(name = "units", nullable = true, length = 255)
    private String units;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByIdProduct")
    private Collection<InlineModel> inlinesById;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByIdProduct")
    private Collection<ProductPromotionModel> productPromotionsById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_gender", referencedColumnName = "id")
    private GenderModel gendersByIdGender;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_presentation", referencedColumnName = "id", nullable = false)
    private PresentationModel presentationsByIdPresentation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getIdGender() {
        return idGender;
    }

    public void setIdGender(Integer idGender) {
        this.idGender = idGender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public int getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(int idPresentation) {
        this.idPresentation = idPresentation;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductModel that = (ProductModel) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<InlineModel> getInlinesById() {
        return inlinesById;
    }

    public void setInlinesById(Collection<InlineModel> inlinesById) {
        this.inlinesById = inlinesById;
    }

    public Collection<ProductPromotionModel> getProductPromotionsById() {
        return productPromotionsById;
    }

    public void setProductPromotionsById(Collection<ProductPromotionModel> productPromotionsById) {
        this.productPromotionsById = productPromotionsById;
    }

    public GenderModel getGendersByIdGender() {
        return gendersByIdGender;
    }

    public void setGendersByIdGender(GenderModel gendersByIdGender) {
        this.gendersByIdGender = gendersByIdGender;
    }

    public PresentationModel getPresentationsByIdPresentation() {
        return presentationsByIdPresentation;
    }

    public void setPresentationsByIdPresentation(PresentationModel presentationsByIdPresentation) {
        this.presentationsByIdPresentation = presentationsByIdPresentation;
    }

}
