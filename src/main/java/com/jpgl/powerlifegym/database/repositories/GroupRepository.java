package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

}
