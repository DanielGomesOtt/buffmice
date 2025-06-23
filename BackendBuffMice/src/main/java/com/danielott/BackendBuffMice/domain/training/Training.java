package com.danielott.BackendBuffMice.domain.training;

import com.danielott.BackendBuffMice.domain.training.dto.TrainingCreatedDTO;
import com.danielott.BackendBuffMice.domain.users.Users;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Date;


@Table(name = "training")
@Entity(name = "Training")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date limit_date;
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users user;

    public Training(@Valid TrainingCreatedDTO data, Users user) {
        this.title = data.title();
        this.limit_date = data.limit_date();
        this.user = user;
        this.status = data.status();
    }

    public Training(Long id, String title, Date limit_date, Users user, int status) {
        this.id = id;
        this.title = title;
        this.limit_date = limit_date;
        this.user = user;
        this.status = status;
    }

    public Training(Long id, int status) {
        this.id = id;
        this.status = status;
    }

    public Training(String title, int status, Users user) {
        this.title = title;
        this.status = status;
        this.user = user;
    }
}
