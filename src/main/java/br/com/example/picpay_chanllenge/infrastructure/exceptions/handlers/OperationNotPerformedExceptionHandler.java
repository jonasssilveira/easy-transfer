package br.com.example.picpay_chanllenge.infrastructure.exceptions.handlers;

import br.com.example.picpay_chanllenge.domain.exception.OperationNotPerformedException;
import br.com.example.picpay_chanllenge.infrastructure.exceptions.OperationNotPerformedExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class OperationNotPerformedExceptionHandler {
    @ExceptionHandler(OperationNotPerformedException.class)
    ResponseEntity<OperationNotPerformedExceptionDetails> handlerNotFoundException(OperationNotPerformedException operationNotPerformedException) {
        return new ResponseEntity<>(
                new OperationNotPerformedExceptionDetails(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        "Operation not performed due rules",
                        operationNotPerformedException.getMessage(),
                        operationNotPerformedException.getClass().getName()
                ), HttpStatus.BAD_REQUEST);

    }

}
