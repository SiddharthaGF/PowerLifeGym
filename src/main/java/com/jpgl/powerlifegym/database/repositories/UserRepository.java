package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    public List<UserModel> findByNickContainingOrEmailContaining(String Nick, String Email);

}
