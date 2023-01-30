package com.jpgl.powerlifegym.repositories.people;

import com.jpgl.powerlifegym.models.people.AdminModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminModel, Integer> {

}
