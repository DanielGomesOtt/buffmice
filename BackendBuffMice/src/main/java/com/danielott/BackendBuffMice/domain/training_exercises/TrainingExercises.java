package com.danielott.BackendBuffMice.domain.training_exercises;

import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import com.danielott.BackendBuffMice.domain.training.Training;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "training_exercises")
@Entity(name = "TrainingExercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TrainingExercises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id")
    private Training training;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    private int status;
}
