package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.training.Training;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingCreatedDTO;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingFormatted;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingUpdateDTO;
import com.danielott.BackendBuffMice.domain.training.repositories.TrainingRepository;
import com.danielott.BackendBuffMice.domain.training.validations.TrainingValidation;
import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TrainingService {

    @Autowired
    private TrainingRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private List<TrainingValidation> validations;

    public TrainingCreatedDTO save (TrainingCreatedDTO data) {
        Users user = usersRepository.findById(data.users_id()).get();
        Training training = new Training(null, data.title(), data.limit_date(), data.status(), user);

        validations.forEach(validation -> validation.validate(training));

        Training createdTraining = repository.save(training);
        return new TrainingCreatedDTO(createdTraining);
    }

    public Training update (TrainingUpdateDTO data) {
        try {
            Training updatedTraining = repository.findById(data.id()).get();
            if(data.title() != null) {
                updatedTraining.setTitle(data.title());
            }

            if(data.limit_date() != null) {
                updatedTraining.setLimit_date(data.limit_date());
            }
            return repository.findById(data.id()).get();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Long id) {
        try {
            Training deletedTraining = repository.findById(id).get();
            deletedTraining.setStatus(0);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TrainingFormatted> getTrainingByUser(Long usersId) {
        try {
            var user = usersRepository.findById(usersId);
            Optional<Training> trainings = repository.findByUserAndStatus(user, 1);
            List<TrainingFormatted> formattedTrainings = trainings.stream().map(TrainingFormatted::new).toList();
            return formattedTrainings;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
