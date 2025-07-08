package com.danielott.BackendBuffMice.controllers;


import com.danielott.BackendBuffMice.domain.training.Training;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingCreatedDTO;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingFormatted;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingUpdateDTO;
import com.danielott.BackendBuffMice.services.TrainingService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService service;

    @PostMapping
    @Transactional
    public ResponseEntity<TrainingCreatedDTO> save (@RequestBody TrainingCreatedDTO data) {
        TrainingCreatedDTO createdTraining = service.save(data);
        return ResponseEntity.status(201).body(createdTraining);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TrainingUpdateDTO> update (@RequestBody TrainingUpdateDTO data) {
        Training updatedTraining = service.update(data);
        TrainingUpdateDTO formattedUpdatedTraining = new TrainingUpdateDTO(updatedTraining);
        return ResponseEntity.ok(formattedUpdatedTraining);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{usersId}")
    public ResponseEntity<List<TrainingFormatted>> getTrainingByUser(@PathVariable Long usersId) {
        List<TrainingFormatted> trainings = service.getTrainingByUser(usersId);
        return ResponseEntity.ok(trainings);
    }
}
