package com.jpgl.powerlifegym.models.offer.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.models.people.ClientModel;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "physical_monitoring")
public class PhysicalMonitoringModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "height", nullable = false)
    private int height;
    @Basic
    @Column(name = "id_client", nullable = false, insertable=false, updatable=false)
    private int idClient;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "weight", nullable = false)
    private int weight;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id", nullable = false)
    private ClientModel clientsByIdClient;

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhysicalMonitoringModel that = (PhysicalMonitoringModel) o;

        if (id != that.id) return false;
        if (height != that.height) return false;
        if (idClient != that.idClient) return false;
        if (weight != that.weight) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + height;
        result = 31 * result + idClient;
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + weight;
        return result;
    }

    public ClientModel getClientsByIdClient() {
        return clientsByIdClient;
    }

    public void setClientsByIdClient(ClientModel clientsByIdClient) {
        this.clientsByIdClient = clientsByIdClient;
    }
}
