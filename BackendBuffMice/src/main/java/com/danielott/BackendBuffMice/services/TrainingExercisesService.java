package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.exercise.repositories.ExerciseRepository;
import com.danielott.BackendBuffMice.domain.training.repositories.TrainingRepository;
import com.danielott.BackendBuffMice.domain.training_exercises.TrainingExercises;
import com.danielott.BackendBuffMice.domain.training_exercises.TrainingExercisesRepository;
import com.danielott.BackendBuffMice.domain.training_exercises.dto.TrainingExercisesCreatedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingExercisesService {

    @Autowired
    private TrainingExercisesRepository repository;

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;


    public List<TrainingExercisesCreatedDTO> save (List<TrainingExercisesCreatedDTO> data) {
        try {
            List<TrainingExercises> createdTrainingExercises = data.stream().map(dto -> {
                var training = trainingRepository.findById(dto.training_id()).get();
                var exercise = exerciseRepository.findById(dto.exercise_id()).get();
                var trainingExercises = new TrainingExercises(null, training, exercise, dto.status());
                return trainingExercises;
            }).collect(Collectors.toList());

            repository.saveAll(createdTrainingExercises);
            var formatedCreatedTrainingExercises = createdTrainingExercises.stream().map(TrainingExercisesCreatedDTO::new);
            return formatedCreatedTrainingExercises.toList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
