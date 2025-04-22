package com.danielott.BackendBuffMice.domain.training_exercises.dto;

import com.danielott.BackendBuffMice.domain.training_exercises.TrainingExercises;
import jakarta.validation.constraints.NotNull;

public record TrainingExercisesCreatedDTO(
        @NotNull
        Long training_id,

        @NotNull
        Long exercise_id,

        @NotNull
        int status
) {
    public TrainingExercisesCreatedDTO(TrainingExercises trainingExercises) {
        this(trainingExercises.getTraining().getId(), trainingExercises.getExercise().getId(), trainingExercises.getStatus());
    }
}
