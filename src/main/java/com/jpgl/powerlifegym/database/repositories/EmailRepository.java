package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.EmailModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<EmailModel, Integer> {

}
