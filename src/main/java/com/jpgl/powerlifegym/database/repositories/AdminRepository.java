package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.person.AdminModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminModel, Integer> {

}
