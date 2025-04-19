package com.danielott.BackendBuffMice.controllers;

import com.danielott.BackendBuffMice.domain.exercise.dto.ExerciseListDTO;
import com.danielott.BackendBuffMice.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @GetMapping
    public ResponseEntity<Stream<ExerciseListDTO>> findAll (@RequestParam(required = false) String name, @RequestParam(required = false) String muscle) {
        var exercises = service.findAll(name, muscle);
        return ResponseEntity.ok(exercises);
    }
}
