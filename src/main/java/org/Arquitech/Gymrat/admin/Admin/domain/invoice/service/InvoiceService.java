package org.Arquitech.Gymrat.admin.Admin.domain.invoice.service;

import org.Arquitech.Gymrat.admin.Admin.resource.invoice.CreateInvoiceResource;
import org.Arquitech.Gymrat.admin.Admin.resource.invoice.InvoiceResource;
import org.Arquitech.Gymrat.admin.Admin.resource.invoice.UpdateInvoiceResource;

import java.util.List;

public interface InvoiceService {
    List<InvoiceResource> getAllInvoices();
    InvoiceResource getInvoiceById(Long id);
    InvoiceResource createInvoice(CreateInvoiceResource resource);
    InvoiceResource updateInvoice(Long id, UpdateInvoiceResource resource);
}
