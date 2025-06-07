package com.danielott.BackendBuffMice.domain.exercise_observation.dto;

public record ExerciseObservationFormattedDTO(
        Long id,
        String observation

) {

    public ExerciseObservationFormattedDTO(ExerciseObservationFormattedDTO exerciseObservationFormattedDTO) {
        this(exerciseObservationFormattedDTO.id(), exerciseObservationFormattedDTO.observation());
    }
}
