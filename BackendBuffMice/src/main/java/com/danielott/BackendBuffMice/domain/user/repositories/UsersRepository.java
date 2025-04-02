package com.danielott.BackendBuffMice.domain.user.repositories;

import com.danielott.BackendBuffMice.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, Long> {

    UserDetails findByEmail(String email);
}
