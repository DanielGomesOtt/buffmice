package com.danielott.BackendBuffMice.controllers;

import com.danielott.BackendBuffMice.domain.exercise_observation.dto.ExerciseObservationCreatedDTO;
import com.danielott.BackendBuffMice.domain.exercise_observation.dto.ExerciseObservationFormattedDTO;
import com.danielott.BackendBuffMice.services.ExerciseObservationService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exercise_observation")
public class ExerciseObservationController {

    @Autowired
    private ExerciseObservationService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ExerciseObservationCreatedDTO> save(@RequestBody ExerciseObservationCreatedDTO data) {
        ExerciseObservationCreatedDTO createdExerciseObservation = service.save(data);
        return ResponseEntity.status(201).body(createdExerciseObservation);
    }

    @GetMapping
    public ResponseEntity<List<ExerciseObservationFormattedDTO>> findAll(@RequestParam(required = true) Long exercise_id, @RequestParam(required = true) Long user_id)  {
        var exerciseObservations = service.find(exercise_id, user_id);
        return ResponseEntity.ok(exerciseObservations);
    }
}
