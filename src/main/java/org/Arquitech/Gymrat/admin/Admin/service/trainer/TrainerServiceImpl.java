package org.Arquitech.Gymrat.admin.Admin.service.trainer;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.Arquitech.Gymrat.admin.Admin.domain.trainer.model.entity.Trainer;
import org.Arquitech.Gymrat.admin.Admin.domain.trainer.persistence.TrainerRepository;
import org.Arquitech.Gymrat.admin.Admin.domain.trainer.service.TrainerService;
import org.Arquitech.Gymrat.admin.Shared.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private Validator validator;

    public TrainerServiceImpl(TrainerRepository trainerRepository, Validator validator) {
        this.trainerRepository = trainerRepository;
        this.validator = validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Trainer> fetchAll() {
        return trainerRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Trainer> fetchById(Integer id) {
        if(trainerRepository.existsById(id)) {
            return trainerRepository.findById(id);
        } else {
            throw new CustomException("Trainer not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Trainer save(Trainer trainer) {
        Set<ConstraintViolation<Trainer>> violations = validator.validate(trainer);
        if (!violations.isEmpty()) {
            throw new CustomException("Error", HttpStatus.NOT_FOUND);
        }
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainer update(Trainer trainer) {
        Set<ConstraintViolation<Trainer>> violations = validator.validate(trainer);
        if(!violations.isEmpty()) {
            throw new CustomException("Error", HttpStatus.NOT_FOUND);
        }

        return trainerRepository
                .findById(trainer.getId())
                .map(trainerToUpdate -> {
                    trainerToUpdate.setName(trainer.getName());
                    trainerToUpdate.setPhone(trainer.getPhone());
                    trainerToUpdate.setEmail(trainer.getEmail());
                    trainerToUpdate.setSpecialization(trainer.getSpecialization());

                    return trainerRepository.save(trainerToUpdate);
                })
                .orElseThrow(() -> new CustomException("Trainer not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public boolean deleteById(Integer id) {
        var trainerToDelete = trainerRepository.findById(id)
                .orElseThrow(() -> new CustomException("Trainer not found", HttpStatus.NOT_FOUND));

        trainerRepository.delete(trainerToDelete);
        return true;
    }
}
