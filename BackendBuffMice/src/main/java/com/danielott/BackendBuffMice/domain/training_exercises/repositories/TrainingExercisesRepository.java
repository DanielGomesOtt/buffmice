package com.danielott.BackendBuffMice.domain.training_exercises.repositories;

import com.danielott.BackendBuffMice.domain.training_exercises.TrainingExercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingExercisesRepository  extends JpaRepository<TrainingExercises, Long> {
}
