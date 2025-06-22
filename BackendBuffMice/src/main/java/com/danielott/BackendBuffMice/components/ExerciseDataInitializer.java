package com.danielott.BackendBuffMice.components;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import com.danielott.BackendBuffMice.domain.exercise.repositories.ExerciseRepository;
import com.danielott.BackendBuffMice.services.ExternalExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class ExerciseDataInitializer {

    @Autowired
    private ExerciseRepository repository;

    @Autowired
    private ExternalExerciseService service;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        if(!repository.existsByIdIsNotNull()) {
            var exercises = service.fetchExercises();
            Arrays.asList(exercises).stream().forEach(obj -> {
                var exercise = new Exercise(obj);
                repository.save(exercise);
            });
        }
    }
}
