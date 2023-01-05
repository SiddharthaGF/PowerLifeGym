package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByNickContainingOrEmailContaining(String Nick, String Email);

}
