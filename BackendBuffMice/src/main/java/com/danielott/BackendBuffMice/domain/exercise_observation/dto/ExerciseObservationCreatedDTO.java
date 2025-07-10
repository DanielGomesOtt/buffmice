package com.danielott.BackendBuffMice.domain.exercise_observation.dto;

import com.danielott.BackendBuffMice.domain.exercise_observation.ExerciseObservation;

public record ExerciseObservationCreatedDTO(
        Long id,

        Long exercise_id,

        Long user_id,

        String observation,

        int status
) {
    public ExerciseObservationCreatedDTO(ExerciseObservation exerciseObservation) {
        this(exerciseObservation.getId(), exerciseObservation.getExercise().getId(), exerciseObservation.getUser().getId(), exerciseObservation.getObservation(), exerciseObservation.getStatus());
    }
}
