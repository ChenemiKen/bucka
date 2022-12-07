package com.chenemiken.bucka.controller;

import com.chenemiken.bucka.pojo.User;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  List<User> users = new ArrayList<>();

  @PostMapping("/auth/signup")
  public ResponseEntity<User> signUp(@RequestBody @Valid User user){
    users.add(user);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @GetMapping("/auth/users")
  public ResponseEntity<List<User>> allUsers(){
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
}