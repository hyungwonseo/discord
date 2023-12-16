package com.dw.discord.jwtauthority.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dw.discord.jwtauthority.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 @EntityGraph(attributePaths = "authorities")
	 Optional<User> findOneWithAuthoritiesByUsername(String username);
}
