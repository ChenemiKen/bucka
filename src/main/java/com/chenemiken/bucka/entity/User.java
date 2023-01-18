package com.chenemiken.bucka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
  @NotNull(message = "Email is required")
  @NotBlank(message = "Email can not be blank")
  @NonNull
  private String email;

  @Column
  @NotNull(message = "Username is required")
  @NotBlank(message = "Username can not be blank")
  @NonNull
  private String username;

  @Column
  @NotNull(message = "Password is required")
  @NotBlank(message = "Password can not be blank")
  @NonNull
  private String password;
}
