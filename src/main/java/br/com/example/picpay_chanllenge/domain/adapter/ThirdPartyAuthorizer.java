package br.com.example.picpay_chanllenge.domain.adapter;


import br.com.example.picpay_chanllenge.domain.dto.out.AuthorizerOutDTO;

public interface ThirdPartyAuthorizer {
    AuthorizerOutDTO authorize();
}
