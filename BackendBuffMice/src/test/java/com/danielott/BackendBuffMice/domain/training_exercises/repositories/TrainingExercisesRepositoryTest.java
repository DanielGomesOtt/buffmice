package com.danielott.BackendBuffMice.domain.training_exercises.repositories;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import com.danielott.BackendBuffMice.domain.training.Training;
import com.danielott.BackendBuffMice.domain.training_exercises.TrainingExercises;
import com.danielott.BackendBuffMice.domain.training_exercises.dto.TrainingExerciseFormattedDTO;
import com.danielott.BackendBuffMice.domain.users.Users;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class TrainingExercisesRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    TrainingExercisesRepository trainingExercisesRepository;

    @Test
    @DisplayName("Should get a list of training exercises")
    void findActiveTrainingExercisesByTrainingIdCase1() {
        Users user = this.createUser();
        Training training = this.createTraining(user);
        Exercise exercise = this.createExercise();
        TrainingExercises trainingExercises = createTrainingExercise(training, exercise);

        Optional<List<TrainingExerciseFormattedDTO>> result = this.trainingExercisesRepository.findActiveTrainingExercisesByTrainingId(training.getId());

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should get a empty list of training exercises")
    void findActiveTrainingExercisesByTrainingIdCase2() {

        Optional<List<TrainingExerciseFormattedDTO>> result = this.trainingExercisesRepository.findActiveTrainingExercisesByTrainingId(6L);

        assertThat(result.get().isEmpty()).isTrue();
    }

    private Users createUser() {
        Users user = new Users("User 1", "user@email.com", "123456");
        this.entityManager.persist(user);
        return user;
    }

    private Training createTraining(Users user) {
        Training training = new Training("first training", 1, user);
        this.entityManager.persist(training);
        return training;
    }

    private Exercise createExercise() {
        Exercise exercise = new Exercise(null, "exercise 1", "description of exercise 1", "muscle", "secondary muscles", "gif url .com");
        this.entityManager.persist(exercise);
        return exercise;
    }

    private TrainingExercises createTrainingExercise(Training training, Exercise exercise) {
        TrainingExercises trainingExercises = new TrainingExercises(null, training, exercise, 1);
        this.entityManager.persist(trainingExercises);
        return trainingExercises;
    }
}