package br.com.example.picpay_chanllenge.domain.dto;

import java.util.Map;

public record AuthorizerDTO(String status,
                            Map<String, String> data) {
}
