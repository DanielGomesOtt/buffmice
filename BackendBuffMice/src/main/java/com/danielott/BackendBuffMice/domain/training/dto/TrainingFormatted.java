package com.danielott.BackendBuffMice.domain.training.dto;

import com.danielott.BackendBuffMice.domain.training.Training;

import java.util.Date;

public record TrainingFormatted(
        Long id,
        String title,
        Date limit_date
) {
    public TrainingFormatted (Training training){
        this(training.getId(), training.getTitle(), training.getLimit_date());
    }
}
