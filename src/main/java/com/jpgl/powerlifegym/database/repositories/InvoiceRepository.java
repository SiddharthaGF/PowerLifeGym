package com.jpgl.powerlifegym.database.repositories;

import com.jpgl.powerlifegym.database.models.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {

}
