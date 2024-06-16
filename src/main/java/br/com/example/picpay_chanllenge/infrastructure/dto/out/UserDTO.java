package br.com.example.picpay_chanllenge.infrastructure.dto.out;

import br.com.example.picpay_chanllenge.domain.entity.User;

public record UserDTO(
        Long id,
        String fullUserName,
        Long cpf,
        String email,
        String password,
        Boolean shopkeeper,
        Long saldo) {
    public User userDTOTOUser() {
        return new User(id, fullUserName, cpf, email, password, shopkeeper, saldo);
    }
}
