package com.jpgl.powerlifegym.repositories.people;

import com.jpgl.powerlifegym.models.people.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    public boolean existsByCellPhoneNumber(String cellPhoneNumber);

}
