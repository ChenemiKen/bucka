package com.chenemiken.bucka.service;

import com.chenemiken.bucka.entity.User;

public interface UserService {
  User getUser(Long id);
  User saveUser(User user);
  User getUser(String username);

}
