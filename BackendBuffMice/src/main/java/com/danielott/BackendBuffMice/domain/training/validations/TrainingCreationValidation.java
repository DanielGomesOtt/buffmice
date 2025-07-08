package com.danielott.BackendBuffMice.domain.training.validations;

import com.danielott.BackendBuffMice.domain.training.Training;
import com.danielott.BackendBuffMice.exceptions.TrainingCreationException;
import org.springframework.stereotype.Component;

@Component
public class TrainingCreationValidation implements TrainingValidation{
    @Override
    public void validate(Training training) {
        if(training.getTitle() == null || training.getTitle().isEmpty()) {
            throw new TrainingCreationException("The training needs a title.");
        }
    }
}
