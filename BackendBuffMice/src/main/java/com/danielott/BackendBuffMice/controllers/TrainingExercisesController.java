package com.danielott.BackendBuffMice.controllers;

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
    public ResponseEntity save (@RequestBody @Valid List<TrainingExercisesCreatedDTO> data) {
        service.save(data);
        return ResponseEntity.ok(data);
    }
}
