package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<Email, Integer> {

}
