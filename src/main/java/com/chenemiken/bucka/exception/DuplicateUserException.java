package com.chenemiken.bucka.exception;

public class DuplicateUserException extends RuntimeException{

  public DuplicateUserException(String field, String Value){
    super(field + " has already been registered");
  }

}
