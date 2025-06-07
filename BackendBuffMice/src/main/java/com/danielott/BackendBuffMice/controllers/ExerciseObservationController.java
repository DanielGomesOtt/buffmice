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
    public ResponseEntity save(@RequestBody @Valid ExerciseObservationCreatedDTO data) {
        service.save(data);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<ExerciseObservationFormattedDTO>> findAll(@RequestParam(required = true) Long exercise_id, @RequestParam(required = true) Long user_id)  {
        var exerciseObservations = service.find(exercise_id, user_id);
        return ResponseEntity.ok(exerciseObservations);
    }
}
