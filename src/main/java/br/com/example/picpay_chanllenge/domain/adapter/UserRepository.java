package br.com.example.picpay_chanllenge.domain.adapter;

import br.com.example.picpay_chanllenge.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    Optional<User> findByCPF(String cpf);
    void deposit(Long id, Long amount);
    void withdraw(Long id, Long amount);
}
