package br.com.example.picpay_chanllenge.infrastructure.service;

import br.com.example.picpay_chanllenge.domain.adapter.TransferenciaRepository;
import br.com.example.picpay_chanllenge.domain.adapter.UserRepository;
import br.com.example.picpay_chanllenge.domain.entity.Transfer;
import br.com.example.picpay_chanllenge.domain.entity.User;
import br.com.example.picpay_chanllenge.infrastructure.dto.out.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;
    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void merge(User user) {
        this.userRepository.merge(user);
    }

    public UserDTO findByEmail(String email){
        return this.userRepository.findByEmail(email).map(user -> {
            return new UserDTO(user.Id(),
                    user.fullUserName(),
                    user.cpf(),
                    user.email(),
                    user.password(),
                    user.shopkeeper(),
                    user.saldo());
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO findById(String id){
        return this.userRepository.findByEmail(id).map(user -> {
            return new UserDTO(user.Id(),
                    user.fullUserName(),
                    user.cpf(),
                    user.email(),
                    user.password(),
                    user.shopkeeper(),
                    user.saldo());
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO findByCPF(String cpf){
        return this.userRepository.findByEmail(cpf).map(user -> {
            return new UserDTO(user.Id(),
                    user.fullUserName(),
                    user.cpf(),
                    user.email(),
                    user.password(),
                    user.shopkeeper(),
                    user.saldo());
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deposit(Long id, Long amount){
        this.userRepository.deposit(id, amount);
    }

    public void withdraw(Long id, Long amount){
        this.userRepository.withdraw(id, amount);
    }

}
