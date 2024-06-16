package br.com.example.picpay_chanllenge.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record User(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Long Id,
        @Column(name = "full_user_name")
        String fullUserName,
        @Column(unique = true, nullable = false)
        Long cpf,
        @Column(unique = true, nullable = false)
        String email,
        String password,
        Boolean shopkeeper,
        Long saldo) {
}
