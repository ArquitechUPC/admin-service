package org.Arquitech.Gymrat.admin.Admin.service.invoice;

import org.Arquitech.Gymrat.admin.Admin.domain.invoice.model.entity.Invoice;
import org.Arquitech.Gymrat.admin.Admin.domain.invoice.persistence.InvoiceRepository;
import org.Arquitech.Gymrat.admin.Admin.domain.invoice.service.InvoiceService;
import org.Arquitech.Gymrat.admin.Admin.resource.clientService.ClientServiceClient;
import org.Arquitech.Gymrat.admin.Admin.resource.invoice.CreateInvoiceResource;
import org.Arquitech.Gymrat.admin.Admin.resource.invoice.InvoiceResource;
import org.Arquitech.Gymrat.admin.Admin.resource.invoice.UpdateInvoiceResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientServiceClient clientServiceClient;

    public List<InvoiceResource> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public InvoiceResource getInvoiceById(Long id) {
        return convertToDto(invoiceRepository.findById(id).orElseThrow());
    }

    public InvoiceResource createInvoice(CreateInvoiceResource resource) {
        Invoice invoice = new Invoice();
        invoice.setClientName(resource.getClientName());
        invoice.setAmount(resource.getAmount());
        invoice.setPaymentDate(resource.getPaymentDate());
        invoice.setPaymentStatus(resource.getPaymentStatus());
        invoice.setStripeTransactionId(resource.getStripeTransactionId());
        invoice.setEmail(clientServiceClient.getClientEmail(resource.getClientId()));
        return convertToDto(invoiceRepository.save(invoice));
    }

    public InvoiceResource updateInvoice(Long id, UpdateInvoiceResource resource) {
        Invoice existingInvoice = invoiceRepository.findById(id).orElseThrow();
        if (resource.getClientName() != null) {
            existingInvoice.setClientName(resource.getClientName());
        }
        if (resource.getAmount() != null) {
            existingInvoice.setAmount(resource.getAmount());
        }
        if (resource.getPaymentDate() != null) {
            existingInvoice.setPaymentDate(resource.getPaymentDate());
        }
        if (resource.getPaymentStatus() != null) {
            existingInvoice.setPaymentStatus(resource.getPaymentStatus());
        }
        if (resource.getSentDate() != null) {
            existingInvoice.setSentDate(resource.getSentDate());
        }
        if (resource.getInvoiceStatus() != null) {
            existingInvoice.setInvoiceStatus(resource.getInvoiceStatus());
        }

        return convertToDto(invoiceRepository.save(existingInvoice));
    }

    private InvoiceResource convertToDto(Invoice invoice) {
        InvoiceResource dto = new InvoiceResource();
        dto.setId(invoice.getId());
        dto.setClientName(invoice.getClientName());
        dto.setAmount(invoice.getAmount());
        dto.setPaymentDate(invoice.getPaymentDate());
        dto.setPaymentStatus(invoice.getPaymentStatus());
        dto.setStripeTransactionId(invoice.getStripeTransactionId());
        dto.setEmail(invoice.getEmail());
        dto.setSentDate(invoice.getSentDate());
        dto.setInvoiceStatus(invoice.getInvoiceStatus());
        return dto;
    }

}