package br.com.example.picpay_chanllenge.infrastructure.dto.out;

import br.com.example.picpay_chanllenge.domain.entity.User;
import org.bouncycastle.crypto.generators.BCrypt;

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

    public static UserDTO userTODTO(User user) {
        return new UserDTO(user.getId(),
                user.getFullUserName(),
                user.getCpf(),
                user.getEmail(),
                user.getPassword(),
                user.getShopkeeper(),
                user.getSaldo());
    }

}
