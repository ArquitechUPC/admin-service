package org.Arquitech.Gymrat.admin.Admin.resource.invoice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateInvoiceResource {
    private String clientName;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentStatus;
    private String stripeTransactionId;
    private Integer clientId;
}