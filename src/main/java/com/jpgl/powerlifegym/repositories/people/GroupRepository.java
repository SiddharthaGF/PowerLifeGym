package com.jpgl.powerlifegym.repositories.people;

import com.jpgl.powerlifegym.models.people.GroupModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupModel, Integer> {

}
