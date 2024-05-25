package org.Arquitech.Gymrat.admin.Admin.domain.invoice.persistence;

import org.Arquitech.Gymrat.admin.Admin.domain.invoice.model.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Optional<Invoice> findByStripeTransactionId(String stripeTransactionId);

}