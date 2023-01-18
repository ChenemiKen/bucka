package com.chenemiken.bucka.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class ErrorResponse {
  private List<String> message;

  @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timeStamp;

  public ErrorResponse(List<String> message){
    this.timeStamp = LocalDateTime.now();
    this.message = message;
  }

  public void setTimeStamp(LocalDateTime timeStamp){
    this.timeStamp = timeStamp;
  }

  public void setMessage(List<String> message){
    this.message = message;
  }
}