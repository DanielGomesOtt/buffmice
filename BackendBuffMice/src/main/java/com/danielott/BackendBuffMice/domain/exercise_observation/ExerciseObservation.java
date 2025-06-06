package com.danielott.BackendBuffMice.domain.exercise_observation;


import com.danielott.BackendBuffMice.domain.exercise.Exercise;
import com.danielott.BackendBuffMice.domain.users.Users;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "exercise_observation")
@Entity(name = "ExerciseObservation")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ExerciseObservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    private String observation;
    private int status;

    public ExerciseObservation(Long id, Exercise exercise, Users user, String observation, int status) {
        this.user = user;
        this.exercise = exercise;
        this.observation = observation;
        this.status = status;
    }
}
