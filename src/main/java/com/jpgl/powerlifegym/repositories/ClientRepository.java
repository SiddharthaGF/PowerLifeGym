package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
