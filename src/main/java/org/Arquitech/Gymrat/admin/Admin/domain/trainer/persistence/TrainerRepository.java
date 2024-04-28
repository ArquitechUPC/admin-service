package org.Arquitech.Gymrat.admin.Admin.domain.trainer.persistence;

import org.Arquitech.Gymrat.admin.Admin.domain.trainer.model.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

}
