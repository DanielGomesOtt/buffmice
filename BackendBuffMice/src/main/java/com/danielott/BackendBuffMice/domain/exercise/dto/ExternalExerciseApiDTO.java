package com.danielott.BackendBuffMice.domain.exercise.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalExerciseApiDTO (
        String name,
        String description,
        String bodyPart,
        List<String> secondaryMuscles,
        String gifUrl
){
}
