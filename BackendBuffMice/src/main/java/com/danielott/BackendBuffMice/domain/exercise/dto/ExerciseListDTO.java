package com.danielott.BackendBuffMice.domain.exercise.dto;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;

public record ExerciseListDTO(Long id, String Name, String description, String muscle, String secondary_muscle, String gif_url) {

    public ExerciseListDTO(Exercise exercise) {
        this(exercise.getId(), exercise.getName(), exercise.getDescription(), exercise.getMuscle(), exercise.getSecondary_muscle(), exercise.getGif_url());
    }
}
