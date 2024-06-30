package br.com.example.picpay_chanllenge.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OperationNotPerformedException extends RuntimeException{

    public OperationNotPerformedException(String message) {
        super(message);
    }

}