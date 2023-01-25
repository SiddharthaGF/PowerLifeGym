package com.jpgl.powerlifegym.database.models.person.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpgl.powerlifegym.database.models.person.GroupModel;
import com.jpgl.powerlifegym.database.models.person.UserModel;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@DiscriminatorValue(value="instructor")
public class InstructorModel extends UserModel {
    @Basic
    @Column(name = "id_specialization")
    private int idSpecialization;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_specialization", referencedColumnName = "id", insertable=false, updatable=false)
    private SpecializationModel specializationsByIdSpecialization;

    public int getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(int idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "instructorsByIdInstructor")
    private Collection<GroupModel> groupssesById;

    public Collection<GroupModel> getGroupssesById() {
        return groupssesById;
    }

    public void setGroupssesById(Collection<GroupModel> groupssesById) {
        this.groupssesById = groupssesById;
    }

    public SpecializationModel getSpecializationsByIdSpecialization() {
        return specializationsByIdSpecialization;
    }

    public void setSpecializationsByIdSpecialization(SpecializationModel specializationsByIdSpecialization) {
        this.specializationsByIdSpecialization = specializationsByIdSpecialization;
    }
}
