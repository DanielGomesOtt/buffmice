package com.danielott.BackendBuffMice.domain.exercise_observation.dto;

import com.danielott.BackendBuffMice.domain.exercise_observation.ExerciseObservation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExerciseObservationCreatedDTO(
        @NotNull
        Long exercise_id,

        @NotNull
        Long user_id,

        @NotBlank
        String observation,

        @NotNull
        int status
) {
    public ExerciseObservationCreatedDTO(ExerciseObservation exerciseObservation) {
        this(exerciseObservation.getExercise().getId(), exerciseObservation.getUser().getId(), exerciseObservation.getObservation(), exerciseObservation.getStatus());
    }
}
