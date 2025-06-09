package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.training.Training;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingCreatedDTO;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingUpdateDTO;
import com.danielott.BackendBuffMice.domain.training.repositories.TrainingRepository;
import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrainingService {

    @Autowired
    private TrainingRepository repository;
    @Autowired
    private UsersRepository usersRepository;

    public TrainingCreatedDTO save (TrainingCreatedDTO data) {
        try {
            var user = usersRepository.findById(data.users_id()).get();
            Training training = new Training(null, data.title(), data.limit_date(), data.status(), user);
            repository.save(training);
            return new TrainingCreatedDTO(training);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Training update (TrainingUpdateDTO data) {
        try {
            Users user = usersRepository.findById(data.id()).get();
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
        Training deletedTraining = repository.findById(id).get();
        deletedTraining.setStatus(0);
    }
}
