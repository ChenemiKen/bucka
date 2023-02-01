package com.chenemiken.bucka.security;

import com.chenemiken.bucka.security.filter.AuthenticationFilter;
import com.chenemiken.bucka.security.filter.ExceptionHandlerFilter;
import com.chenemiken.bucka.security.filter.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Autowired
  CustomAuthenticationManager customAuthenticationManager;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
    authenticationFilter.setFilterProcessesUrl("/auth/login");

    http
        .csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.POST, "/auth/signup").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
        .addFilter(authenticationFilter)
        .addFilterAfter(new JWTAuthenticationFilter(), AuthenticationFilter.class);

    return http.build();
  }

}
