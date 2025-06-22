package com.danielott.BackendBuffMice.domain.training_exercises.repositories;

import com.danielott.BackendBuffMice.domain.training_exercises.TrainingExercises;
import com.danielott.BackendBuffMice.domain.training_exercises.dto.TrainingExerciseFormattedDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;


public interface TrainingExercisesRepository  extends JpaRepository<TrainingExercises, Long> {

    @Query("SELECT new com.danielott.BackendBuffMice.domain.training_exercises.dto.TrainingExerciseFormattedDTO(" +
            "e.name, e.description, e.muscle, e.secondary_muscle, t.title) " +
            "FROM TrainingExercises te " +
            "JOIN te.training t " +
            "JOIN te.exercise e " +
            "WHERE te.status = 1 AND t.id = :id")
    List<TrainingExerciseFormattedDTO> findActiveTrainingExercisesByTrainingId(@Param("id") Long id);

    Optional<TrainingExercises> findByIdAndStatus(Long id, int status);
}
