package org.Arquitech.Gymrat.admin.Admin.api.rest.invoice;

import org.Arquitech.Gymrat.admin.Admin.domain.invoice.service.InvoiceService;
import org.Arquitech.Gymrat.admin.Admin.resource.invoice.CreateInvoiceResource;
import org.Arquitech.Gymrat.admin.Admin.resource.invoice.InvoiceResource;
import org.Arquitech.Gymrat.admin.Admin.resource.invoice.UpdateInvoiceResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<InvoiceResource>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResource> getInvoiceById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @PostMapping
    public ResponseEntity<InvoiceResource> createInvoice(@RequestBody CreateInvoiceResource resource) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.createInvoice(resource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResource> updateInvoice(@PathVariable Long id, @RequestBody UpdateInvoiceResource resource) {
        return ResponseEntity.ok(invoiceService.updateInvoice(id, resource));
    }

}