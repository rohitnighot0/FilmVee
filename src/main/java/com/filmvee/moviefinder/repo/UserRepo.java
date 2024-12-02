package com.filmvee.moviefinder.repo;

import com.filmvee.moviefinder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String username);

    boolean existsByEmail(String email);
}
