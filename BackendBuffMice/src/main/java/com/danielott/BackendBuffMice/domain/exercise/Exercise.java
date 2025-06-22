package com.danielott.BackendBuffMice.domain.exercise;

import com.danielott.BackendBuffMice.domain.exercise.dto.ExternalExerciseApiDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "exercise")
@Entity(name = "Exercise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String muscle;
    private String secondary_muscle;
    private String gif_url;

    public Exercise(ExternalExerciseApiDTO externalExerciseApiDTO) {
        this.name = externalExerciseApiDTO.name();
        this.description = externalExerciseApiDTO.description();
        this.muscle = externalExerciseApiDTO.bodyPart();
        this.secondary_muscle = String.join(", ", externalExerciseApiDTO.secondaryMuscles());
        this.gif_url = externalExerciseApiDTO.gifUrl();
    }
}
