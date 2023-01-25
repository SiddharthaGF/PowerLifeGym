package com.jpgl.powerlifegym.database.models.offer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.database.models.invoice.InlineModel;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "offers")
@DiscriminatorColumn( name = "type_offer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class OfferModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByIdProduct")
    private Collection<InlineModel> inlinesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Collection<InlineModel> getInlinesById() {
        return inlinesById;
    }

    public void setInlinesById(Collection<InlineModel> inlinesById) {
        this.inlinesById = inlinesById;
    }

}
