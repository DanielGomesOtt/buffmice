package com.danielott.BackendBuffMice.domain.training.repositories;

import com.danielott.BackendBuffMice.domain.training.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long>{
}
