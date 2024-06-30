package br.com.example.picpay_chanllenge.infrastructure.exceptions.handlers;

import br.com.example.picpay_chanllenge.domain.exception.NotFoundRequestException;
import br.com.example.picpay_chanllenge.infrastructure.exceptions.NotFoundRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(NotFoundRequestException.class)
    ResponseEntity<NotFoundRequestExceptionDetails> handlerNotFoundException(NotFoundRequestException notFoundRequestException) {
        return new ResponseEntity<>(
                new NotFoundRequestExceptionDetails(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        "Not Found Exception",
                        notFoundRequestException.getMessage(),
                        notFoundRequestException.getClass().getName()
                ), HttpStatus.NOT_FOUND);

    }

}
