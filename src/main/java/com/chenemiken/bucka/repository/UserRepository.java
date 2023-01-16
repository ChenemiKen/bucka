package com.chenemiken.bucka.repository;

import com.chenemiken.bucka.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
