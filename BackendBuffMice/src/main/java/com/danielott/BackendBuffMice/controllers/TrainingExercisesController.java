package com.danielott.BackendBuffMice.controllers;

import com.danielott.BackendBuffMice.domain.training_exercises.dto.TrainingExerciseFormattedDTO;
import com.danielott.BackendBuffMice.domain.training_exercises.dto.TrainingExercisesCreatedDTO;
import com.danielott.BackendBuffMice.services.TrainingExercisesService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/training_exercises")
public class TrainingExercisesController {

    @Autowired
    private TrainingExercisesService service;

    @PostMapping
    @Transactional
    public ResponseEntity<List<TrainingExercisesCreatedDTO>> save (@RequestBody @Valid List<TrainingExercisesCreatedDTO> data) {
        List<TrainingExercisesCreatedDTO>createdTrainingExercises = service.save(data);
        return ResponseEntity.status(201).body(createdTrainingExercises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TrainingExerciseFormattedDTO>> find(@PathVariable Long id) {
        var trainingExercises = service.find(id);
        return ResponseEntity.ok(trainingExercises);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
