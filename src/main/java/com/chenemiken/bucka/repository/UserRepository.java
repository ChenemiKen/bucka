package com.chenemiken.bucka.repository;

import com.chenemiken.bucka.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> getUserByUsername(String username);
  Optional<User> getUserByEmail(String email);
}
