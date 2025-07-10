package com.danielott.BackendBuffMice.domain.training_exercises.dto;

import com.danielott.BackendBuffMice.domain.training_exercises.TrainingExercises;
import jakarta.validation.constraints.NotNull;

public record TrainingExercisesCreatedDTO(
        Long training_id,

        Long exercise_id,

        int status
) {
    public TrainingExercisesCreatedDTO(TrainingExercises trainingExercises) {
        this(trainingExercises.getTraining().getId(), trainingExercises.getExercise().getId(), trainingExercises.getStatus());
    }
}
