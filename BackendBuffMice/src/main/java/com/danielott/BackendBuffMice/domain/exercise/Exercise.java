package com.danielott.BackendBuffMice.domain.exercise;

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

}
