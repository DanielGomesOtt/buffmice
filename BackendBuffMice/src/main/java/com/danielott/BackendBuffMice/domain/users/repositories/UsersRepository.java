package com.danielott.BackendBuffMice.domain.users.repositories;

import com.danielott.BackendBuffMice.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<UserDetails> findByEmail(String email);
}
