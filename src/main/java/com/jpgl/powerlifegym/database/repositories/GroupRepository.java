package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.person.GroupModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupModel, Integer> {

}
