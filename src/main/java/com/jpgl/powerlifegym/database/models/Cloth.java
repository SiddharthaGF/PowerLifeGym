package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "clothes")
@PrimaryKeyJoinColumn ( name = "id_product")
public class Cloth extends Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_product", insertable = false, updatable = false)
    private int idProduct;
    @Basic
    @Column(name = "id_gender")
    private int idGender;
    @Basic
    @Column(name = "size")
    private String size;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Product productsByIdProduct;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_gender", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Gender gendersByIdGender;

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

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

        Cloth cloth = (Cloth) o;

        if (id != cloth.id) return false;
        if (idProduct != cloth.idProduct) return false;
        if (idGender != cloth.idGender) return false;
        if (size != null ? !size.equals(cloth.size) : cloth.size != null) return false;
        if (color != null ? !color.equals(cloth.color) : cloth.color != null) return false;
        if (createdAt != null ? !createdAt.equals(cloth.createdAt) : cloth.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(cloth.updatedAt) : cloth.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idProduct;
        result = 31 * result + idGender;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
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

    public Gender getGendersByIdGender() {
        return gendersByIdGender;
    }

    public void setGendersByIdGender(Gender gendersByIdGender) {
        this.gendersByIdGender = gendersByIdGender;
    }
}
