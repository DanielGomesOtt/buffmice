package com.danielott.BackendBuffMice.domain.training_exercises.dto;

public record TrainingExerciseFormattedDTO(
        String name,
        String description,
        String muscle,
        String secondary_muscle,
        String title
) {

    public TrainingExerciseFormattedDTO(TrainingExerciseFormattedDTO trainingExercises) {
        this(trainingExercises.name, trainingExercises.description(),
                trainingExercises.muscle(), trainingExercises.secondary_muscle(),
                trainingExercises.title());

    }
}
