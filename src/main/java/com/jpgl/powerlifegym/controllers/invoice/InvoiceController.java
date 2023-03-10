package com.jpgl.powerlifegym.controllers.invoice;

import com.jpgl.powerlifegym.models.invoice.InvoiceModel;
import com.jpgl.powerlifegym.services.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class InvoiceController {

    @Autowired
    InvoiceService service;

    @GetMapping("/invoices")
    public List<InvoiceModel> index() {
        return service.All();
    }

    @GetMapping("/invoice/{id}")
    public Optional<InvoiceModel> show(@PathVariable int id) {
        return service.Find(id);
    }

    @PutMapping("/invoice/{model}")
    public boolean create(@PathVariable InvoiceModel model) {
        return service.Add(model);
    }

    @DeleteMapping("/invoice/{model}")
    public boolean destroy(@PathVariable InvoiceModel model) {
        return service.Delete(model);
    }

}
