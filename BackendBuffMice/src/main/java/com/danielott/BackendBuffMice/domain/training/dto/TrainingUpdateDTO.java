package com.danielott.BackendBuffMice.domain.training.dto;

import com.danielott.BackendBuffMice.domain.training.Training;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record TrainingUpdateDTO(
        @NotNull
        Long id,
        String title,
        Date limit_date
) {
    public TrainingUpdateDTO(Training updatedTraining) {
        this(updatedTraining.getId(), updatedTraining.getTitle(), updatedTraining.getLimit_date());
    }
}
