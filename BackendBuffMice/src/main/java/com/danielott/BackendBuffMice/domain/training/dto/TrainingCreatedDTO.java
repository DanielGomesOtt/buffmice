package com.danielott.BackendBuffMice.domain.training.dto;

import com.danielott.BackendBuffMice.domain.training.Training;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record TrainingCreatedDTO(
        @NotBlank
        String title,

        @Future
        Date limit_date,

        @NotNull
        Long users_id,

        @NotNull
        int status
) {
        public TrainingCreatedDTO(Training training) {
                this(training.getTitle(), training.getLimit_date(), training.getUser().getId(), training.getStatus());
        }
}
