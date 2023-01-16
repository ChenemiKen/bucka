package com.chenemiken.bucka.service;

import com.chenemiken.bucka.entity.User;
import com.chenemiken.bucka.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserServiceImpl implements UserService{

//  private BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  UserRepository userRepository;

  @Override
  public User getUser(Long id){
    try{
      return unwrapUser(userRepository.findById(id), id);
    }catch (Exception e){
      return null;
    }
  }

  @Override
  public User saveUser(User user) {
//    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  static User unwrapUser(Optional<User> entity, Long id) throws Exception {
    if(entity.isPresent()) return entity.get();
    else throw new Exception();
  }
}