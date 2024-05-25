package org.Arquitech.Gymrat.admin.Admin.resource.clientService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service", url = "http://localhost:8081")
@Component
public interface ClientServiceClient {

    @GetMapping("/api/v1/clients/{clientId}/email")
    String getClientEmail(@PathVariable Integer clientId);
}
