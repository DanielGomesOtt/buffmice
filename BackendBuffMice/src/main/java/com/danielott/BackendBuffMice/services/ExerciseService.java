package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.exercise.dto.ExerciseListDTO;
import com.danielott.BackendBuffMice.domain.exercise.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository repository;

    public Page<ExerciseListDTO> findAll (@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var exercises = repository.findAll(pagination).map(ExerciseListDTO::new);
        return exercises;
    }
}
