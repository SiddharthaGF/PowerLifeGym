package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
