package br.com.example.picpay_chanllenge.infrastructure.repository;

import br.com.example.picpay_chanllenge.domain.adapter.UserRepository;
import br.com.example.picpay_chanllenge.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepositoryJPA extends UserRepository, JpaRepository<User, Long> {
    void merge(User user);

    @Query("SELECT u FROM user u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM user u WHERE u.id = ?1")
    Optional<User> findById(String id);

    @Query("SELECT u FROM user u WHERE u.cpf = ?1")
    Optional<User> findByCPF(String cpf);

    @Modifying
    @Query("UPDATE user u SET u.saldo = u.saldo - ?2 WHERE u.id = ?1")
    Optional<User> deposit(Long id, Long amount);

    @Modifying
    @Query("UPDATE user u SET u.saldo = u.saldo + ?2 WHERE u.id = ?1")
    Optional<User> withdraw(Long id, Long amount);
}
