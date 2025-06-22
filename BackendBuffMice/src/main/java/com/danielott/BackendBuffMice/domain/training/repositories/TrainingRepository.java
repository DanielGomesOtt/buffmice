package com.danielott.BackendBuffMice.domain.training.repositories;

import com.danielott.BackendBuffMice.domain.training.Training;
import com.danielott.BackendBuffMice.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training, Long>{

    Optional<Training> findByUserAndStatus(Optional<Users> user, int status);
}
