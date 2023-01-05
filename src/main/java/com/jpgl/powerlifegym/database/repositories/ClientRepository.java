package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
