package com.danielott.BackendBuffMice.domain.exercise.repositories;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByNameContainingIgnoreCaseOrMuscleContainingIgnoreCase(String name, String muscle);

    List<Exercise> findByNameContainingIgnoreCase(String name);

    List<Exercise> findByMuscleContainingIgnoreCase(String muscle);

}
