package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.training.Training;
import com.danielott.BackendBuffMice.domain.training.dto.TrainingCreatedDTO;
import com.danielott.BackendBuffMice.domain.training.repositories.TrainingRepository;
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
}
