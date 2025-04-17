package com.danielott.BackendBuffMice.controllers;

import com.danielott.BackendBuffMice.domain.exercise.dto.ExerciseListDTO;
import com.danielott.BackendBuffMice.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @GetMapping
    public ResponseEntity<Page<ExerciseListDTO>> findAll (@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var exercises = service.findAll(pagination);
        return ResponseEntity.ok(exercises);
    }
}
