package br.com.example.picpay_chanllenge.domain.dto.out;

import java.util.Map;

public record NotifyOutDTO(String status,
                           Map<String, String> data) {
}
