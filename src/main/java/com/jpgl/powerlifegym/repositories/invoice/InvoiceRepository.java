package com.jpgl.powerlifegym.repositories.invoice;

import com.jpgl.powerlifegym.models.invoice.InvoiceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceModel, Integer> {

}
