package br.com.example.picpay_chanllenge.domain.entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Id;

public record Transfer(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Long Id,
        Long value,
        @OneToOne(optional = false, fetch = FetchType.LAZY)
        User payer,
        @OneToOne(optional = false, fetch = FetchType.LAZY)
        User payee) {
}
