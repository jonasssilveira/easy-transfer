package br.com.example.picpay_chanllenge.domain.dto.out;

import java.util.Map;

public record AuthorizerOutDTO(String status,
                            Map<String, Boolean> data) {
}
