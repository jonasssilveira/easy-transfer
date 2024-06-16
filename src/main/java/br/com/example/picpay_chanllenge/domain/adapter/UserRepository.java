package br.com.example.picpay_chanllenge.domain.adapter;

import br.com.example.picpay_chanllenge.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    void merge(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(String id);
    Optional<User> findByCPF(String cpf);
    Optional<User> deposit(Long id, Long amount);
    Optional<User> withdraw(Long id, Long amount);
}
