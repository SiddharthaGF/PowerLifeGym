package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "clothes")
@PrimaryKeyJoinColumn ( name = "id_product")
public class Cloth extends Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_cloth;
    @Basic
    @Column(name = "id_product", insertable = false, updatable = false)
    private Integer idProduct;
    @Basic
    @Column(name = "id_gender")
    private Integer idGender;
    @Basic
    @Column(name = "size")
    private String size;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAtCloth;
    @Basic
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAtCloth;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id", insertable = false, updatable = false)
    private Product productsByIdProduct;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_gender", referencedColumnName = "id", insertable = false, updatable = false)
    private Gender productsByIdGender;

    public int getId() {
        return id_cloth;
    }

    public void setId(int id) {
        this.id_cloth = id;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Timestamp getCreatedAtCloth() {
        return createdAtCloth;
    }

    public Timestamp getUpdatedAtCloth() {
        return updatedAtCloth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Cloth that = (Cloth) o;
        return id_cloth == that.id_cloth && Objects.equals (idProduct, that.idProduct) && Objects.equals (idGender, that.idGender) && Objects.equals (size, that.size) && Objects.equals (color, that.color) && Objects.equals (createdAtCloth, that.createdAtCloth) && Objects.equals (updatedAtCloth, that.updatedAtCloth);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id_cloth, idProduct, idGender, size, color, createdAtCloth, updatedAtCloth);
    }

    public Product getProductsByIdProduct() {
        return productsByIdProduct;
    }

    public void setProductsByIdProduct(Product productsByIdProduct) {
        this.productsByIdProduct = productsByIdProduct;
    }
}
