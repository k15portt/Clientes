package com.curso.cursado2.excepciones;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(MethodArgumentNotValidException ex){
        StringBuilder errores = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.append(error.getField())
                        .append(": ")
                        .append(error.getDefaultMessage())
                        .append("; "));
        ApiResponse<Void> respuesta = new ApiResponse<>(false,"Errores de validación " + errores.toString(), null);
        return ResponseEntity.badRequest().body(respuesta);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityException(DataIntegrityViolationException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: El email ya está en uso.");
    }
    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<ApiResponse<Void>> handleEmailDuplicadoException(EmailDuplicadoException ex){
        ApiResponse<Void> respuesta = new ApiResponse<>(false, ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }
}