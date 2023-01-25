package com.jpgl.powerlifegym.database.models.offer.product;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cloth")
public class ClothModel extends ProductModel {

    @Basic
    @Column(name = "color", length = 255)
    private String color;
    @Basic
    @Column(name = "gender")
    private char gender;
    @Basic
    @Column(name = "size", length = 255)
    private String size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
