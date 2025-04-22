package com.danielott.BackendBuffMice.controllers;


import com.danielott.BackendBuffMice.domain.training.dto.TrainingCreatedDTO;
import com.danielott.BackendBuffMice.services.TrainingService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService service;

    @PostMapping
    @Transactional
    public ResponseEntity save (@RequestBody @Valid TrainingCreatedDTO data) {
        service.save(data);
        return ResponseEntity.ok(data);
    }
}
