package org.Arquitech.Gymrat.admin.Admin.mapping.trainer;

import org.Arquitech.Gymrat.admin.Admin.domain.trainer.model.entity.Trainer;
import org.Arquitech.Gymrat.admin.Admin.resource.trainer.CreateTrainerResource;
import org.Arquitech.Gymrat.admin.Admin.resource.trainer.TrainerResource;
import org.Arquitech.Gymrat.admin.Admin.resource.trainer.UpdateTrainerResource;
import org.Arquitech.Gymrat.admin.Shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class TrainerMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Trainer toModel(CreateTrainerResource resource) {return this.mapper.map(resource, Trainer.class);}
    public Trainer toModel(UpdateTrainerResource resource) {return this.mapper.map(resource, Trainer.class);}
    public TrainerResource toResource(Trainer trainer) {return this.mapper.map(trainer, TrainerResource.class);}
}
