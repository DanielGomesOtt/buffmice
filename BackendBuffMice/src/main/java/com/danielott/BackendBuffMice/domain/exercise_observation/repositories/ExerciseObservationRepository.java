package com.danielott.BackendBuffMice.domain.exercise_observation.repositories;

import com.danielott.BackendBuffMice.domain.exercise_observation.ExerciseObservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseObservationRepository extends JpaRepository<ExerciseObservation, Long> {
}
