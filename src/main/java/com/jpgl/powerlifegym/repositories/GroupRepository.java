package com.jpgl.powerlifegym.repositories;

import com.jpgl.powerlifegym.models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

}
