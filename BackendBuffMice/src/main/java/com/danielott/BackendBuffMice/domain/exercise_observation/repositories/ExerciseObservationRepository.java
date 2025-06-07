package com.danielott.BackendBuffMice.domain.exercise_observation.repositories;


import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import com.danielott.BackendBuffMice.domain.exercise_observation.ExerciseObservation;
import com.danielott.BackendBuffMice.domain.exercise_observation.dto.ExerciseObservationFormattedDTO;
import com.danielott.BackendBuffMice.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseObservationRepository extends JpaRepository<ExerciseObservation, Long> {
    List<ExerciseObservationFormattedDTO> findByExerciseAndUserAndStatus(Exercise exercise, Users user, int status);
}
