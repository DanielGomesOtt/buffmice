package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import com.danielott.BackendBuffMice.domain.exercise.repositories.ExerciseRepository;
import com.danielott.BackendBuffMice.domain.exercise_observation.ExerciseObservation;
import com.danielott.BackendBuffMice.domain.exercise_observation.dto.ExerciseObservationCreatedDTO;
import com.danielott.BackendBuffMice.domain.exercise_observation.repositories.ExerciseObservationRepository;
import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseObservationService {

    @Autowired
    private ExerciseObservationRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public ExerciseObservationCreatedDTO save(ExerciseObservationCreatedDTO data){
        try {
            Users user = usersRepository.findById(data.user_id()).get();
            Exercise exercise = exerciseRepository.findById(data.exercise_id()).get();
            ExerciseObservation exerciseObservation = new ExerciseObservation(null, exercise, user, data.observation(), data.status());
            repository.save(exerciseObservation);
            return new ExerciseObservationCreatedDTO(exerciseObservation);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
