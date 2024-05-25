package org.Arquitech.Gymrat.admin.Admin.resource.invoice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateInvoiceResource {
    private String clientName;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentStatus; // "pending", "paid", "expired"
    private LocalDateTime sentDate;
    private String invoiceStatus; // "sent", "paid", "pending"
}
