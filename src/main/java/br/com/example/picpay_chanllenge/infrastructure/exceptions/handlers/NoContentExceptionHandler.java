package br.com.example.picpay_chanllenge.infrastructure.exceptions.handlers;

import br.com.example.picpay_chanllenge.domain.exception.NoContentRequestException;
import br.com.example.picpay_chanllenge.infrastructure.exceptions.NoContentRequestExceptionDetails;
import br.com.example.picpay_chanllenge.domain.exception.NotFoundRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class NoContentExceptionHandler {
    @ExceptionHandler(NoContentRequestException.class)
    ResponseEntity<NoContentRequestExceptionDetails> handlerNotFoundException(NotFoundRequestException notFoundRequestException) {
        return new ResponseEntity<>(
                new NoContentRequestExceptionDetails(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        "no content",
                        notFoundRequestException.getMessage(),
                        notFoundRequestException.getClass().getName())
                , HttpStatus.NOT_FOUND);

    }

}
