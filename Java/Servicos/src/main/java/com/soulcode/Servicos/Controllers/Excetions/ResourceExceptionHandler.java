package com.soulcode.Servicos.Controllers.Excetions;

import com.soulcode.Servicos.Services.Exceptions.DataIntegrityViolationException;
import com.soulcode.Servicos.Services.Exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        StandardError erro = new StandardError();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError("Registro não encontrado");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());
        erro.setTrace("EntityNotFoundException");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    public ResponseEntity<StandardError> DataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        StandardError erro = new StandardError();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setError("Violação de tipo de dados");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getRequestURI());
        erro.setTrace("DataIntegrityViolationException");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
