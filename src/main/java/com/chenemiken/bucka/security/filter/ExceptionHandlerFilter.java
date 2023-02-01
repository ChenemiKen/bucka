package com.chenemiken.bucka.security.filter;

import com.chenemiken.bucka.exception.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
      try{
        filterChain.doFilter(request, response);
      }catch (EntityNotFoundException e){
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        response.getWriter().write(e.getMessage());
        response.getWriter().flush();
      }
  }
}
