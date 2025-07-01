package com.danielott.BackendBuffMice.components;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import com.danielott.BackendBuffMice.domain.exercise.repositories.ExerciseRepository;
import com.danielott.BackendBuffMice.services.ExternalExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.Arrays;


//This component was used to fetch exercise data from the Exercise DB API for the first time.
// To avoid issues for users who don’t have an Exercise DB account, I turned this process into a migration.
//@Component
public class ExerciseDataInitializer {

    @Autowired
    private ExerciseRepository repository;

    @Autowired
    private ExternalExerciseService service;

    //@EventListener(ApplicationReadyEvent.class)
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
