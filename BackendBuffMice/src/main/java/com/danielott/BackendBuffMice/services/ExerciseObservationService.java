package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import com.danielott.BackendBuffMice.domain.exercise.repositories.ExerciseRepository;
import com.danielott.BackendBuffMice.domain.exercise_observation.ExerciseObservation;
import com.danielott.BackendBuffMice.domain.exercise_observation.dto.ExerciseObservationCreatedDTO;
import com.danielott.BackendBuffMice.domain.exercise_observation.dto.ExerciseObservationFormattedDTO;
import com.danielott.BackendBuffMice.domain.exercise_observation.repositories.ExerciseObservationRepository;
import com.danielott.BackendBuffMice.domain.exercise_observation.validations.ExerciseObservationValidation;
import com.danielott.BackendBuffMice.domain.users.Users;
import com.danielott.BackendBuffMice.domain.users.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExerciseObservationService {

    @Autowired
    private ExerciseObservationRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private List<ExerciseObservationValidation> validations;

    public ExerciseObservationCreatedDTO save(ExerciseObservationCreatedDTO data){
        Users user = usersRepository.findById(data.user_id()).get();
        Exercise exercise = exerciseRepository.findById(data.exercise_id()).get();
        ExerciseObservation exerciseObservation = new ExerciseObservation(exercise, user, data.observation(), data.status());
        validations.forEach(validation -> validation.validate(exerciseObservation));
        ExerciseObservation createdExerciseObservation = repository.save(exerciseObservation);
        return new ExerciseObservationCreatedDTO(createdExerciseObservation);
    }

    public List<ExerciseObservationFormattedDTO> find(Long exercise_id, Long user_id) {
        Users user = usersRepository.findById(user_id).get();
        Exercise exercise = exerciseRepository.findById(exercise_id).get();
        return repository
                .findByExerciseAndUserAndStatus(exercise, user, 1).stream()
                .map(ExerciseObservationFormattedDTO::new).toList();
    }


}
