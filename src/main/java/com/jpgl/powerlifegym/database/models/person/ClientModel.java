package com.jpgl.powerlifegym.database.models.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.database.models.invoice.InvoiceModel;
import com.jpgl.powerlifegym.database.models.promotion.SubscriptionPaymentModel;
import com.jpgl.powerlifegym.database.models.offer.services.PhysicalMonitoringModel;
import com.jpgl.powerlifegym.database.models.offer.services.PresenceClientsModel;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@DiscriminatorValue(value="client")
public class ClientModel extends UserModel {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientModel that = (ClientModel) o;

        if (super.getId() != that.getId()) return false;
        if (super.getBirthdate() != null ? !getBirthdate().equals(that.getBirthdate()) : that.getBirthdate() != null) return false;
        if (super.getCreatedAt() != null ? !getCreatedAt().equals(that.getCreatedAt()) : that.getCreatedAt() != null) return false;
        if (super.getDni() != null ? !getDni().equals(that.getDni()) : that.getDni() != null) return false;
        if (super.getLastname() != null ? !getLastname().equals(that.getLastname()) : that.getLastname() != null) return false;
        if (super.getName() != null ? !getName() .equals(that.getName() ) : that.getName()  != null) return false;
        if (super.getUpdatedAt() != null ? !getUpdatedAt().equals(that.getUpdatedAt()) : that.getUpdatedAt() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getBirthdate() != null ? getBirthdate().hashCode() : 0);
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        result = 31 * result + (getDni() != null ? getDni().hashCode() : 0);
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        return result;
    }

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
