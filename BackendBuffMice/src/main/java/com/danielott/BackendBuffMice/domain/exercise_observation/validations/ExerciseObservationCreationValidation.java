package com.danielott.BackendBuffMice.domain.exercise_observation.validations;

import com.danielott.BackendBuffMice.domain.exercise_observation.ExerciseObservation;
import com.danielott.BackendBuffMice.exceptions.ExerciseObservationCreationException;
import org.springframework.stereotype.Component;

@Component
public class ExerciseObservationCreationValidation implements ExerciseObservationValidation{
    @Override
    public void validate(ExerciseObservation exerciseObservation) {
        if (exerciseObservation.getObservation() == null || exerciseObservation.getObservation().isEmpty()) {
            throw new ExerciseObservationCreationException("The observation field cannot be empty.");
        }
    }
}
