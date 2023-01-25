package com.jpgl.powerlifegym.database.models.person;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value="administrator")
public class AdminModel extends UserModel {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminModel that = (AdminModel) o;

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

}
