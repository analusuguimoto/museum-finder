package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
* General Controller Advice.
*/
@ControllerAdvice
public class GeneralControllerAdvice {
  @ExceptionHandler
  public ResponseEntity<String> handleInvalidCoordinateException(InvalidCoordinateException err) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenada inválida!");
  }

  @ExceptionHandler
  public ResponseEntity<String> handleNotFoundException(MuseumNotFoundException err) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Museu não encontrado!");
  }

  @ExceptionHandler
  public ResponseEntity<String> handleAllOtherExceptions(Exception err) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno!");
  }
}
