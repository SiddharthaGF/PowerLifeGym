package com.jpgl.powerlifegym.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "clients")
public class ClientModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "birthdate", nullable = false)
    private Date birthdate;
    @Basic
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Basic
    @Column(name = "dni", nullable = false, length = 10, unique = true)
    private String dni;
    @Basic
    @Column(name = "id_gender", nullable = false)
    private int idGender;
    @Basic
    @Column(name = "lastname", nullable = false, length = 255)
    private String lastname;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp updatedAt;
    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdPerson")
    private Collection<CellphoneNumberModel> cellphoneNumbersById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_gender", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    private GenderModel gendersByIdGender;
    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdPerson")
    private Collection<EmailModel> emailsById;
    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<InscriptionModel> inscriptionsById;
    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<InvoiceModel> invoicesById;
    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<PhysicalMonitoringModel> physicalMonitoringsById;
    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<PresenceClientsModel> presenceClientsById;
    @JsonIgnore
    @OneToMany(mappedBy = "clientsByIdClient")
    private Collection<SubscriptionPaymentModel> subscriptionPaymentsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        ClientModel that = (ClientModel) o;

        if (id != that.id) return false;
        if (idGender != that.idGender) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + idGender;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Collection<CellphoneNumberModel> getCellphoneNumbersById() {
        return cellphoneNumbersById;
    }

    public void setCellphoneNumbersById(Collection<CellphoneNumberModel> cellphoneNumbersById) {
        this.cellphoneNumbersById = cellphoneNumbersById;
    }

    public GenderModel getGendersByIdGender() {
        return gendersByIdGender;
    }

    public void setGendersByIdGender(GenderModel gendersByIdGender) {
        this.gendersByIdGender = gendersByIdGender;
    }

    public Collection<EmailModel> getEmailsById() {
        return emailsById;
    }

    public void setEmailsById(Collection<EmailModel> emailsById) {
        this.emailsById = emailsById;
    }

    public Collection<InscriptionModel> getInscriptionsById() {
        return inscriptionsById;
    }

    public void setInscriptionsById(Collection<InscriptionModel> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }

    public Collection<InvoiceModel> getInvoicesById() {
        return invoicesById;
    }

    public void setInvoicesById(Collection<InvoiceModel> invoicesById) {
        this.invoicesById = invoicesById;
    }

    public Collection<PhysicalMonitoringModel> getPhysicalMonitoringsById() {
        return physicalMonitoringsById;
    }

    public void setPhysicalMonitoringsById(Collection<PhysicalMonitoringModel> physicalMonitoringsById) {
        this.physicalMonitoringsById = physicalMonitoringsById;
    }

    public Collection<PresenceClientsModel> getPresenceClientsById() {
        return presenceClientsById;
    }

    public void setPresenceClientsById(Collection<PresenceClientsModel> presenceClientsById) {
        this.presenceClientsById = presenceClientsById;
    }

    public Collection<SubscriptionPaymentModel> getSubscriptionPaymentsById() {
        return subscriptionPaymentsById;
    }

    public void setSubscriptionPaymentsById(Collection<SubscriptionPaymentModel> subscriptionPaymentsById) {
        this.subscriptionPaymentsById = subscriptionPaymentsById;
    }
}
