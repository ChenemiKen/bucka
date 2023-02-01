package com.chenemiken.bucka;

import com.chenemiken.bucka.exception.DuplicateUserException;
import com.chenemiken.bucka.exception.EntityNotFoundException;
import com.chenemiken.bucka.exception.ErrorResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    List<String> errors = new ArrayList<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));
    return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({DataIntegrityViolationException.class, DuplicateUserException.class, EntityNotFoundException.class})
  public ResponseEntity<Object> handleSQLIntegrityViolationException(RuntimeException ex){
    List<String> errors = new ArrayList<>();
    errors.add(ex.getMessage());

    return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
  }
}
