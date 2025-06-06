package com.danielott.BackendBuffMice.controllers;

import com.danielott.BackendBuffMice.domain.exercise_observation.dto.ExerciseObservationCreatedDTO;
import com.danielott.BackendBuffMice.services.ExerciseObservationService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
}
