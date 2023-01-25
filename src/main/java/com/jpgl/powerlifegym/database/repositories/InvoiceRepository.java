package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.invoice.InvoiceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceModel, Integer> {

}
