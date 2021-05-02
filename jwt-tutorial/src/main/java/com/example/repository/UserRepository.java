package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@EntityGraph(attributePaths = "authorities") //쿼리가 수행이 될때 lAZY조회가 아니고 Eager조회로 authorities정보를 같이 가져오게 된다.
	Optional<User> findOneWithAuthoritiesByUsername(String username);
}