package com.danielott.BackendBuffMice.domain.users.repositories;

import com.danielott.BackendBuffMice.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, Long> {

    UserDetails findByEmail(String email);
}
