package com.danielott.BackendBuffMice.domain.training;

import com.danielott.BackendBuffMice.domain.users.Users;
import jakarta.persistence.*;
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
}
