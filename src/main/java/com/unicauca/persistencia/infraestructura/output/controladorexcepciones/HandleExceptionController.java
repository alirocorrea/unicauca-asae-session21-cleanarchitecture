package com.unicauca.persistencia.infraestructura.output.controladorexcepciones;

import com.unicauca.persistencia.infraestructura.output.controladorexcepciones.excepciones.EntidadNoEncontradaException;
import com.unicauca.persistencia.infraestructura.output.controladorexcepciones.excepciones.ReglaNegocioException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.HashMap;
import java.util.Map;

@Getter
@ControllerAdvice
public class HandleExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(final HttpServletRequest req, final MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, String>> handleHandlerMethodValidationException(final HttpServletRequest req, final HandlerMethodValidationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getAllValidationResults().forEach(parameter ->
            parameter.getResolvableErrors().forEach(error -> {
                String fieldName = parameter.getMethodParameter().getParameterName();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            })
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReglaNegocioException.class)
    public ResponseEntity<ErrorDTORespuesta> handleReglaNegocioException(final HttpServletRequest req, final ReglaNegocioException ex) {
        return new ResponseEntity<>(new ErrorDTORespuesta(ex.getCodigo(), ex.getMessage(), req.getMethod(), req.getRequestURI()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntidadNoEncontradaException.class)
    public ResponseEntity<ErrorDTORespuesta> handleEntidadNoEncontradaException(final HttpServletRequest req, final EntidadNoEncontradaException ex) {
        return new ResponseEntity<>(new ErrorDTORespuesta(ex.getCodigo(), ex.getMessage(), req.getMethod(), req.getRequestURI()), HttpStatus.NOT_FOUND);
    }
}
