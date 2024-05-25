package org.Arquitech.Gymrat.admin.Admin.domain.invoice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private String paymentStatus; // "pending", "paid", "expired"

    @Column(nullable = false)
    private String stripeTransactionId; // ID de la transacción en Stripe

    @Column(nullable = false)
    private String email; // Email del cliente

    private LocalDateTime sentDate; // Fecha de envío del correo electrónico

    private String invoiceStatus; // "sent", "paid", "pending"

}