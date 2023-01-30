package com.jpgl.powerlifegym.repositories.invoice;

import com.jpgl.powerlifegym.models.invoice.InlineModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InlineRepository extends CrudRepository<InlineModel, Integer> {

}
