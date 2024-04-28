package org.Arquitech.Gymrat.admin.Admin.domain.trainer.service;

import org.Arquitech.Gymrat.admin.Admin.domain.trainer.model.entity.Trainer;

import java.util.*;

public interface TrainerService {
    List<Trainer> fetchAll();
    Optional<Trainer> fetchById(Integer id);
    Trainer save(Trainer trainer);
    Trainer update(Trainer trainer);
    boolean deleteById(Integer id);
}
