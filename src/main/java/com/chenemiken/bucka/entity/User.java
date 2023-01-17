package com.chenemiken.bucka.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table()
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @NonNull()
  @NotBlank(message = "Email can not be blank")
  private String email;

  @Column
  @NonNull
  @NotBlank(message = "Username can not be blank")
  private String username;

  @Column
  @NonNull
  @NotBlank(message = "Password can not be blank")
  private String password;
}
