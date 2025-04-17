package com.danielott.BackendBuffMice.domain.exercise.repositories;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
