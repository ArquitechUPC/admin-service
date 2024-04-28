package org.Arquitech.Gymrat.admin.Admin.mapping.trainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("clientMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TrainerMapper trainerMapper() {return new TrainerMapper();}
}
