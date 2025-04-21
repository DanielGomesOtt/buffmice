package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.exercise.dto.ExerciseListDTO;
import com.danielott.BackendBuffMice.domain.exercise.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Stream;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository repository;

    public Stream<ExerciseListDTO> findAll (String name, String muscle) {
        if (name != null && muscle != null) {
            var exercises = repository.findByNameContainingIgnoreCaseOrMuscleContainingIgnoreCase(name, muscle).stream().map(ExerciseListDTO::new);
            return exercises;
        } else if (name != null) {
            var exercises = repository.findByNameContainingIgnoreCase(name).stream().map(ExerciseListDTO::new);
            return exercises;
        } else if (muscle != null) {
            var exercises = repository.findByMuscleContainingIgnoreCase(muscle).stream().map(ExerciseListDTO::new);
            return exercises;
        } else {
            var exercises = repository.findAll().stream().map(ExerciseListDTO::new);
            return exercises;
        }
    }
}
