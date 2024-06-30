package br.com.example.picpay_chanllenge.infrastructure.exceptions;

import java.time.LocalDateTime;

public record NotFoundRequestExceptionDetails(LocalDateTime timestamp,
                                              Integer status,
                                              String title,
                                              String details,
                                              String message) {


}
